package com.zsn.exchanges.fanoutExechange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zsn.utils.RabbitMqConnection;

import java.util.Scanner;

/**
 * @Author : zhou sen nan
 * @Date : 2022/3/8  20:31
 */
public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws Exception {
        Connection connection = RabbitMqConnection.RabbitMqConnectionUtil();
        Channel channel = null;
        channel = connection.createChannel();
/**
 * 声明一个 exchange
 * 1.exchange 的名称
 * 2.exchange 的类型
 */
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入信息");
        while (sc.hasNext()) {
            String message = sc.nextLine();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
            System.out.println("生产者发出消息" + message);
        }
    }
}
