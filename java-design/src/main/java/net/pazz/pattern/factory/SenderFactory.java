package net.pazz.pattern.factory;

/**
 * @author: 彭坚
 * @create: 2018/9/5 17:20
 * @description:
 */
public class SenderFactory {

    public Sender produce(String type){
        if("email".equals(type)){
            return new EmailSender();
        }else if("sms".equals(type)){
            return new SmsSender();
        }
        return null;
    }

    public static void main(String[] args) {
        SenderFactory sendFactory = new SenderFactory();
        Sender sender = sendFactory.produce("sms");
        sender.send();
    }

}
