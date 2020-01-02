package com.pazz.java.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 异步传输
 */
public class AsyncProducer {

    public static void main(String[] args) throws Exception {
        producer();
        consumer();
    }

    public static void producer() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("AsyncProducerGroup");
        producer.setNamesrvAddr("localhost:9876");
        producer.setVipChannelEnabled(false);
        producer.setRetryTimesWhenSendFailed(0);    // 设置发送失败重试时间
        producer.start();
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Message message = new Message("AsyncTopic", "TagA", "orderID188", "Hello word!".getBytes(RemotingHelper.DEFAULT_CHARSET));
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

    public static void consumer() throws Exception {
        // 使用指定的消费者组名称实例化
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("AsyncConsumerGroup");

        // 指定名称服务器地址
        consumer.setNamesrvAddr("localhost:9876");

        // 订阅一个更多的主题来消费  (* 代表所有)
        consumer.subscribe("AsyncTopic", "*");
        // 注册回调函数，以便在从代理获取的消息到达时执行
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        // 启动消费者实例
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }

}
