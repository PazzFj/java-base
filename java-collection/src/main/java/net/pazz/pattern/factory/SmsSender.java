package net.pazz.pattern.factory;

/**
 * @author: 彭坚
 * @create: 2018/9/5 17:18
 * @description:
 */
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("send sms ... ");
    }
}
