package com.zsn.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author : zhou sen nan
 * @Date : 2022/2/14  11:14
 */
public class RabbitMqConnection {
    public static Connection RabbitMqConnectionUtil() {
        Connection connection = null;
        //创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.133.129");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");


        //channel 实现了自动 close 接口 自动关闭 不需要显示关闭
        try {
            connection = connectionFactory.newConnection();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
