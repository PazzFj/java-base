package com.pazz.java.email.pop3;

import lombok.Data;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author: 彭坚
 * @create: 2020/1/9 21:52
 * @description:
 */
public class $_Main {

    @Test
    public void emailSend() throws Exception {
        Properties props = new Properties();
        // POP\SMTP\IMAP
        props.setProperty("mail.transport.protocol", "SMTP");       // 协议
        // pop.exmail.qq.com\smtp.exmail.qq.com\imap.exmail.qq.com
        // pop.263.net\smtp.263.net\imap.263.net
        props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");  // 服务器地址
        // 110\25\143
        props.setProperty("mail.smtp.port", "25");      // 端口号
        props.setProperty("mail.smtp.auth", "true");    // 认证
//        props.setProperty("mail.smtp.timeout", "2000");

        //使用JavaMail发送邮件的5个步骤
        //1、创建session
        Session session = Session.getInstance(props, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("bc@gangrong.pro", "Gr12345678"); //发件人邮件用户名、授权码
                return new PasswordAuthentication("pengjian@eshippinggateway.com", "Nmnb5426"); //发件人邮件用户名、授权码
            }
        });
        //4、创建邮件消息
        Message message = createSimpleMail(session);
        //5、发送邮件
        Transport.send(message);
    }

    @Test
    public void emailReceive() throws Exception {
        /**
         * 因为现在使用的是163邮箱 而163的 pop地址是　pop3.163.com　 端口是　110　　
         * 比如使用好未来企业邮箱 就需要换成 好未来邮箱的 pop服务器地址 pop.263.net  和   端口 110
         */
//        String duankou = "110";// 端口号
        String duankou = "143";// 端口号
//        String servicePath = "pop3.163.com";   // 服务器地址
//        String servicePath = "pop3.mxhichina.com";   // 服务器地址
        String servicePath = "imap.mxhichina.com";   // 服务器地址

        // 准备连接服务器的会话信息
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imap");       // 使用pop3协议
        props.setProperty("mail.imap.port", duankou);           // 端口
        props.setProperty("mail.imap.host", servicePath);       // pop3服务器

        // 创建Session实例对象
        Session session = Session.getInstance(props);
        Store store = session.getStore("imap");
        store.connect("bc@gangrong.pro", "Gr12345678"); //163邮箱程序登录属于第三方登录所以这里的密码是163给的授权密码而并非普通的登录密码

        // 获得收件箱
        Folder folder = store.getFolder("INBOX");
        /* Folder.READ_ONLY：只读权限
         * Folder.READ_WRITE：可读可写（可以修改邮件的状态）
         */
        folder.open(Folder.READ_ONLY); //打开收件箱

        // 由于POP3协议无法获知邮件的状态,所以getUnreadMessageCount得到的是收件箱的邮件总数
        System.out.println("未读邮件数: " + folder.getUnreadMessageCount());

        // 由于POP3协议无法获知邮件的状态,所以下面得到的结果始终都是为0
        System.out.println("删除邮件数: " + folder.getDeletedMessageCount());
        System.out.println("新邮件: " + folder.getNewMessageCount());

        // 获得收件箱中的邮件总数
        System.out.println("邮件总数: " + folder.getMessageCount());

        // 得到收件箱中的所有邮件,并解析
//        Message[] messages = folder.getMessages();
        Message[] messages = folder.getMessages(folder.getMessageCount() - folder.getUnreadMessageCount() + 1, folder.getMessageCount());
        parseMessage(messages);

        //得到收件箱中的所有邮件并且删除邮件
//        deleteMessage(messages);

        //释放资源
        folder.close(true);
        store.close();
    }

    /**
     * 创建简单邮件消息
     */
    public static MimeMessage createSimpleMail(Session session)
            throws Exception {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("pengjian@eshippinggateway.com"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("peng_jian@hoperun.com"));
        //邮件的标题
        message.setSubject("报文邮件");
        //创建邮件正文，为了避免邮件正文中文乱码问题，需要使用charset=UTF-8指明字符编码
        MimeBodyPart text = new MimeBodyPart();
        text.setContent("http://发送邮件报文", "text/html;charset=UTF-8");
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

    /**
     * 解析邮件
     *
     * @param messages 要解析的邮件列表
     */
    public static void parseMessage(Message... messages) throws MessagingException, IOException {
        if (messages == null || messages.length < 1)
            throw new MessagingException("未找到要解析的邮件!");

        // 解析所有邮件
        for (int i = 0, count = messages.length; i < count; i++) {
            MimeMessage msg = (MimeMessage) messages[i];
            System.out.println("------------------解析第" + msg.getMessageNumber() + "封邮件-------------------- ");
            System.out.println("主题: " + getSubject(msg));
            System.out.println("发件人: " + getFrom(msg));
            System.out.println("收件人：" + getReceiveAddress(msg, null));
            System.out.println("发送时间：" + getSentDate(msg, null));
            System.out.println("是否已读：" + isSeen(msg));
//            System.out.println("邮件优先级：" + getPriority(msg));
//            System.out.println("是否需要回执：" + isReplySign(msg));
//            System.out.println("邮件大小：" + msg.getSize() * 1024 + "kb");
            boolean isContainerAttachment = isContainAttachment(msg);
            System.out.println("是否包含附件：" + isContainerAttachment);
            if (isContainerAttachment) {
                saveAttachment(msg, "F:\\testMail\\" + msg.getSubject() + "_" + i + "_"); //保存附件
            }
            StringBuffer content = new StringBuffer(30);
            getMailTextContent(msg, content);
            System.out.println("邮件正文：" + (content.length() > 100 ? content.substring(0, 100) + "..." : content));
            System.out.println("------------------第" + msg.getMessageNumber() + "封邮件解析结束-------------------- ");
            System.out.println();

        }
    }

    /**
     * 解析邮件
     *
     * @param messages 要解析的邮件列表
     */
    public static void deleteMessage(Message... messages) throws MessagingException, IOException {
        if (messages == null || messages.length < 1)
            throw new MessagingException("未找到要解析的邮件!");

        // 解析所有邮件
        for (int i = 0, count = messages.length; i < count; i++) {

            /**
             *   邮件删除
             */
            Message message = messages[i];
            String subject = message.getSubject();
            // set the DELETE flag to true
            message.setFlag(Flags.Flag.DELETED, true);
            System.out.println("Marked DELETE for message: " + subject);


        }
    }

    /**
     * 获得邮件主题
     *
     * @param msg 邮件内容
     * @return 解码后的邮件主题
     */
    public static String getSubject(MimeMessage msg) throws UnsupportedEncodingException, MessagingException {
        return MimeUtility.decodeText(msg.getSubject());
    }

    /**
     * 获得邮件发件人
     *
     * @param msg 邮件内容
     * @return 姓名 <Email地址>
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public static String getFrom(MimeMessage msg) throws MessagingException, UnsupportedEncodingException {
        String from = "";
        Address[] froms = msg.getFrom();
        if (froms.length < 1)
            throw new MessagingException("没有发件人!");

        InternetAddress address = (InternetAddress) froms[0];
        String person = address.getPersonal();
        if (person != null) {
            person = MimeUtility.decodeText(person) + " ";
        } else {
            person = "";
        }
        from = person + "<" + address.getAddress() + ">";

        return from;
    }

    /**
     * 根据收件人类型，获取邮件收件人、抄送和密送地址。如果收件人类型为空，则获得所有的收件人
     * <p>Message.RecipientType.TO  收件人</p>
     * <p>Message.RecipientType.CC  抄送</p>
     * <p>Message.RecipientType.BCC 密送</p>
     *
     * @param msg  邮件内容
     * @param type 收件人类型
     * @return 收件人1 <邮件地址1>, 收件人2 <邮件地址2>, ...
     * @throws MessagingException
     */
    public static String getReceiveAddress(MimeMessage msg, Message.RecipientType type) throws MessagingException {
        StringBuffer receiveAddress = new StringBuffer();
        Address[] addresss = null;
        if (type == null) {
            addresss = msg.getAllRecipients();
        } else {
            addresss = msg.getRecipients(type);
        }

        if (addresss == null || addresss.length < 1)
            throw new MessagingException("没有收件人!");
        for (Address address : addresss) {
            InternetAddress internetAddress = (InternetAddress) address;
            receiveAddress.append(internetAddress.toUnicodeString()).append(",");
        }

        receiveAddress.deleteCharAt(receiveAddress.length() - 1); //删除最后一个逗号

        return receiveAddress.toString();
    }

    /**
     * 获得邮件发送时间
     *
     * @param msg 邮件内容
     * @return yyyy年mm月dd日 星期X HH:mm
     * @throws MessagingException
     */
    public static String getSentDate(MimeMessage msg, String pattern) throws MessagingException {
        Date receivedDate = msg.getSentDate();
        if (receivedDate == null)
            return "";

        if (pattern == null || "".equals(pattern))
            pattern = "yyyy年MM月dd日 E HH:mm ";

        return new SimpleDateFormat(pattern).format(receivedDate);
    }

    /**
     * 判断邮件中是否包含附件
     *
     * @param part 邮件内容
     * @return 邮件中存在附件返回true，不存在返回false
     * @throws MessagingException
     * @throws IOException
     */
    public static boolean isContainAttachment(Part part) throws MessagingException, IOException {
        boolean flag = false;
        if (part.isMimeType("multipart/*")) {
            MimeMultipart multipart = (MimeMultipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    flag = true;
                } else if (bodyPart.isMimeType("multipart/*")) {
                    flag = isContainAttachment(bodyPart);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("application") != -1) {
                        flag = true;
                    }

                    if (contentType.indexOf("name") != -1) {
                        flag = true;
                    }
                }

                if (flag) break;
            }
        } else if (part.isMimeType("message/rfc822")) {
            flag = isContainAttachment((Part) part.getContent());
        }
        return flag;
    }

    /**
     * 判断邮件是否已读
     *
     * @param msg 邮件内容
     * @return 如果邮件已读返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isSeen(MimeMessage msg) throws MessagingException {
        return msg.getFlags().contains(Flags.Flag.SEEN);
    }

    /**
     * 判断邮件是否需要阅读回执
     *
     * @param msg 邮件内容
     * @return 需要回执返回true, 否则返回false
     * @throws MessagingException
     */
    public static boolean isReplySign(MimeMessage msg) throws MessagingException {
        boolean replySign = false;
        String[] headers = msg.getHeader("Disposition-Notification-To");
        if (headers != null)
            replySign = true;
        return replySign;
    }

    /**
     * 获得邮件的优先级
     *
     * @param msg 邮件内容
     * @return 1(High):紧急  3:普通(Normal)  5:低(Low)
     * @throws MessagingException
     */
    public static String getPriority(MimeMessage msg) throws MessagingException {
        String priority = "普通";
        String[] headers = msg.getHeader("X-Priority");
        if (headers != null) {
            String headerPriority = headers[0];
            if (headerPriority.indexOf("1") != -1 || headerPriority.indexOf("High") != -1)
                priority = "紧急";
            else if (headerPriority.indexOf("5") != -1 || headerPriority.indexOf("Low") != -1)
                priority = "低";
            else
                priority = "普通";
        }
        return priority;
    }

    /**
     * 获得邮件文本内容
     *
     * @param part    邮件体
     * @param content 存储邮件文本内容的字符串
     * @throws MessagingException
     * @throws IOException
     */
    public static void getMailTextContent(Part part, StringBuffer content) throws MessagingException, IOException {
        //如果是文本类型的附件，通过getContent方法可以取到文本内容，但这不是我们需要的结果，所以在这里要做判断
        boolean isContainTextAttach = part.getContentType().indexOf("name") > 0;
        if (part.isMimeType("text/*") && !isContainTextAttach) {
            content.append(part.getContent().toString());
        } else if (part.isMimeType("message/rfc822")) {
            getMailTextContent((Part) part.getContent(), content);
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                BodyPart bodyPart = multipart.getBodyPart(i);
                getMailTextContent(bodyPart, content);
            }
        }
    }

    /**
     * 保存附件
     *
     * @param part    邮件中多个组合体中的其中一个组合体
     * @param destDir 附件保存目录
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void saveAttachment(Part part, String destDir) throws UnsupportedEncodingException, MessagingException,
            FileNotFoundException, IOException {
        if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();    //复杂体邮件
            //复杂体邮件包含多个邮件体
            int partCount = multipart.getCount();
            for (int i = 0; i < partCount; i++) {
                //获得复杂体邮件中其中一个邮件体
                BodyPart bodyPart = multipart.getBodyPart(i);
                //某一个邮件体也有可能是由多个邮件体组成的复杂体
                String disp = bodyPart.getDisposition();
                if (disp != null && (disp.equalsIgnoreCase(Part.ATTACHMENT) || disp.equalsIgnoreCase(Part.INLINE))) {
                    InputStream is = bodyPart.getInputStream();
                    try {
                        saveFile(is, destDir, decodeText(bodyPart.getFileName()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ((Message) part).setFlag(Flags.Flag.SEEN, true);
                } else if (bodyPart.isMimeType("multipart/*")) {
                    saveAttachment(bodyPart, destDir);
                } else {
                    String contentType = bodyPart.getContentType();
                    if (contentType.indexOf("name") != -1 || contentType.indexOf("application") != -1) {
                        try {
                            saveFile(bodyPart.getInputStream(), destDir, decodeText(bodyPart.getFileName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ((Message) part).setFlag(Flags.Flag.SEEN, true);
                    }
                }
            }
        } else if (part.isMimeType("message/rfc822")) {
            saveAttachment((Part) part.getContent(), destDir);
        }
    }

    /**
     * 读取输入流中的数据保存至指定目录
     *
     * @param is       输入流
     * @param fileName 文件名
     * @param destDir  文件存储目录
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void saveFile(InputStream is, String destDir, String fileName)
            throws Exception {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);
        List<DcbContainerExcelDto> dtos = new ArrayList<>();
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rowNum; i++) {// 从第2行开始读信息
            Row row = sheet.getRow(i);
            DcbContainerExcelDto uploadDto = new DcbContainerExcelDto();
            uploadDto.setBlNo(row.getCell(0).getStringCellValue());
            dtos.add(uploadDto);
            System.out.println(uploadDto);
        }

    }

    /**
     * 文本解码
     *
     * @param encodeText 解码MimeUtility.encodeText(String text)方法编码后的文本
     * @return 解码后的文本
     * @throws UnsupportedEncodingException
     */
    public static String decodeText(String encodeText) throws UnsupportedEncodingException {
        if (encodeText == null || "".equals(encodeText)) {
            return "";
        } else {
            return MimeUtility.decodeText(encodeText);
        }
    }

    @Data
    public static class DcbContainerExcelDto {

        // 订舱号
        private String blNo;
        //港区代码
        private String attribute1;
        //提还柜
        private String attribute2;
        // 箱型
        private String containerSizeType;
        // 长度
        private String containerLength;
        // 高度
        private String containerHeight;
        // 空重类型
        private String attribute3;
        // 箱主
        private String carrierName;
        // 有效期
        private String indateTime;
        // 备注
        private String remark;
        // 总数
        private Integer allCount;
        // 已提数
        private Integer expendCount;
        // PoolName
        private String poolName;
        //是否成功
        private Boolean isSuccess = true;

    }
}
