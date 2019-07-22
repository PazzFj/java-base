package com.pazz.java.test;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * @author: 彭坚
 * @create: 2019/1/7 13:45
 * @description:
 */
public class POP3SendMailTest {

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            try {
                send();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                POP3ReceiveMailTest.resceive();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void send() throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.smtp.host", "smtp.mxhichina.com");// 服务器地址
        props.setProperty("mail.smtp.port", "25");// 端口号
        props.setProperty("mail.smtp.auth", "true");
//        props.setProperty("mail.smtp.timeout", "2000");

        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bc@gangrong.pro", "Gr12345678"); //发件人邮件用户名、授权码
            }
        });
        //4、创建邮件
        Message message = createSimpleMail(session);
        //5、发送邮件
        Transport.send(message);
    }

    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("bc@gangrong.pro"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("bc@gangrong.pro"));
        //邮件的标题
        message.setSubject("报文邮件测试");
        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("http:// 发送邮件报文测试", "text/html;charset=UTF-8");
        //创建邮件附件1
//        MimeBodyPart attach = new MimeBodyPart();
//        DataHandler dh = new DataHandler(new FileDataSource("F:\\images\\123.png"));
//        attach.setDataHandler(dh);
//        attach.setFileName(dh.getName());

        //创建容器描述数据关系
        MimeMultipart mp = new MimeMultipart();
        mp.addBodyPart(text);
//        mp.addBodyPart(attach);
        mp.setSubType("mixed");

        //邮件的文本内容
        message.setContent(mp);

        //返回创建好的邮件对象
        return message;
    }

}
