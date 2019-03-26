package net.pazz.pattern.factory;

/**
 * @author: 彭坚
 * @create: 2018/9/5 17:20
 * @description:
 */
public class EmailSender implements Sender {
    @Override
    public void send() {
        System.out.println("send email ... ");
    }
}
