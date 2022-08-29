package com.zsn.workqueues;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DeliverCallback;
import com.zsn.utils.RabbitMqConnection;

import java.io.IOException;

/**
 * @Author : zhou sen nan
 * @Date : 2022/2/14  14:35
 */
public class Consumer1 {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMqConnection.RabbitMqConnectionUtil();
        Channel channel = null;
        try {
            channel = connection.createChannel();


        } catch (IOException e) {
            e.printStackTrace();
        }
        //推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) ->
        {
            String message = new String(delivery.getBody());
            System.out.println("接收消息："+message);
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };
        System.out.println("A消费者启动等待消费...");
        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
