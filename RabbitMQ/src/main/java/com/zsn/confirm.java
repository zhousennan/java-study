package com.zsn;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.Connection;
import com.zsn.utils.RabbitMqConnection;

import java.io.IOException;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Author : zhou sen nan
 * @Date : 2022/2/15  11:32
 */
public class confirm {
    public static void main(String[] args) throws IOException, InterruptedException {
        //单个发布确认时间：630ms
        //publishMessageIndividually();
        //批量发布确认时间：142ms
        //publishMessageBatch();
        //异步发布确认时间：46ms
        publishMessageAsync();
    }

    public static void publishMessageIndividually() throws IOException, InterruptedException {
        Connection connection = RabbitMqConnection.RabbitMqConnectionUtil();
        Channel channel = connection.createChannel();
        channel.confirmSelect();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        String queueName = "confirm";
        channel.queueDeclare(queueName, true, false, false, null);
        int messageCount = 1000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < messageCount; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());
            System.out.println("发布消息" + message);
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("单个发布确认时间：" + (end - begin) + "ms");
    }


    public static void publishMessageBatch() throws IOException, InterruptedException {
        Connection connection = RabbitMqConnection.RabbitMqConnectionUtil();
        Channel channel = connection.createChannel();
        channel.confirmSelect();
        //批量确认消息大小
        int batchSize = 100;
        //未确认消息个数
        int outstandingMessageCount = 0;
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        String queueName = "confirm";
        channel.queueDeclare(queueName, true, false, false, null);
        int messageCount = 1000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < messageCount; i++) {
            String message = i + "";
            channel.basicPublish("", queueName, null, message.getBytes());

            outstandingMessageCount++;
            if (outstandingMessageCount == batchSize) {
                channel.waitForConfirms();
                outstandingMessageCount = 0;
            }

        }
        //为了确保还有剩余没有确认消息 再次确认
        if (outstandingMessageCount > 0) {
            channel.waitForConfirms();
        }
        long end = System.currentTimeMillis();
        System.out.println("批量发布确认时间：" + (end - begin) + "ms");
    }


    public static void publishMessageAsync() throws IOException, InterruptedException {

        /**
         * 线程安全有序的一个哈希表，适用于高并发的情况
         * 1.轻松的将序号与消息进行关联
         * 2.轻松批量删除条目 只要给到序列号
         * 3.支持并发访问
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new
                ConcurrentSkipListMap<>();
        Connection connection = RabbitMqConnection.RabbitMqConnectionUtil();
        Channel channel = connection.createChannel();
        channel.confirmSelect();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化 默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除 最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        String queueName = "confirm";
        channel.queueDeclare(queueName, true, false, false, null);
        //成功 1.消息的表示 2.是否 批量确认
        ConfirmCallback ackconfirmCallback = (sequenceNumber, multiple) -> {
            if (multiple) { //返回的是小于等于当前序列号的未确认消息 是一个 map
                ConcurrentNavigableMap<Long,  String> confirmed  =
                        outstandingConfirms.headMap(sequenceNumber, true);
                //清除该部分未确认消
                confirmed.clear();
            }else{ //只清除当前序列号的消
                outstandingConfirms.remove(sequenceNumber);
            }
        };
        //失败
        ConfirmCallback noack = (sequenceNumber, var3) -> {
            String message = outstandingConfirms.get(sequenceNumber);
                System.out.println("发布的消息"+message+"未被确认，序列号"+sequenceNumber);
        };
        /**
         * 1 成功
         * 2 失败
         */
        channel.addConfirmListener(ackconfirmCallback, noack);


        int messageCount = 1000;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < messageCount; i++) {
            String message = i + "";
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
            channel.basicPublish("", queueName, null, message.getBytes());
        }


        long end = System.currentTimeMillis();
        System.out.println("异步发布确认时间：" + (end - begin) + "ms");
    }


}
