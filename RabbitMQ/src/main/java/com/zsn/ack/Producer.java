package com.zsn.ack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @Author : zhou sen nan
 * @Date : 2022/2/14  15:29
 */
public class Producer {
    private final  static String QUEUE_NAME = "task_ack";

    public static void main(String[] args) {
        //创建一个连接工厂
        ConnectionFactory connectionFactory =  new ConnectionFactory();
        connectionFactory.setHost("192.168.133.129");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
        try {
            //channel 实现了自动 close 接口 自动关闭 不需要显示关闭
            Connection connection = connectionFactory.newConnection();
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
            channel.queueDeclare(QUEUE_NAME,true,false,false,null);
            System.out.println("输入发送的消息：");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){

                String message = scanner.next();
                /**
                 * 发送一个消息
                 * 1.发送到那个交换机
                 * 2.路由的 key 是哪个
                 * 3.其他的参数信息
                 * 4.发送消息的消息体
                 */
                channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
                System.out.println("发送消息完成:"+message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
