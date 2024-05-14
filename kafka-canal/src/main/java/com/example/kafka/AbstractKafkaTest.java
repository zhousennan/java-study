package com.example.kafka;


import com.example.BaseCanalClientTest;

/**
 * Kafka 测试基类
 *
 * @author machengyuan @ 2018-6-12
 * @version 1.0.0
 */
public abstract class AbstractKafkaTest extends BaseCanalClientTest {

    public static String  topic     = "example";
    public static Integer partition = null;
    public static String  groupId   = "g4";
    public static String  servers   = "47.108.173.85:9092";
    public static String  zkServers = "47.108.173.85:2181";

    public void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
