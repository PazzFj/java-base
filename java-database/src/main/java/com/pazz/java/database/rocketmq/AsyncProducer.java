package com.pazz.java.database.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 可靠的异步传输
 */
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("ExampleProducerGroup");
        producer.setNamesrvAddr("120.79.141.169:9876");
        producer.setVipChannelEnabled(false);
        producer.start();
        producer.setRetryTimesWhenSendFailed(0);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message("TopicTest", "TagA", "orderID188", "Hello word!".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message);
            producer.send(message, new SendCallback() {
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                }

                public void onException(Throwable throwable) {
                    System.out.printf("%-10d Exception %s %n", index, throwable);
                    throwable.printStackTrace();
                }
            });
        }
        // 当生产者实例不再使用时关闭。
        producer.shutdown();
    }

}
