package com.zsn.algorithm.disruptor;

import com.lmax.disruptor.IgnoreExceptionHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import javafx.event.Event;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/17  14:25
 */
public class MyEventMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        int bufferSize = 1024;
        Disruptor<MyEvent> disruptor = new Disruptor<MyEvent>(new MyEventFactory(),
                bufferSize, executorService, ProducerType.SINGLE, new YieldingWaitStrategy());
        disruptor.handleExceptionsWith(new IgnoreExceptionHandler());
        disruptor.handleEventsWith(new MyEventHandler(),new MyEventHandler());
        RingBuffer<MyEvent> ringBuffer = disruptor.start();

        MyEventProducer producer = new MyEventProducer(ringBuffer);
        for (long i = 0; i < 10; i++) {
            producer.onData(i);
            Thread.sleep(1000);// wait for task execute....
        }

        disruptor.shutdown();

        ExecutorsUtils.shutdownAndAwaitTermination(executorService, 60, TimeUnit.SECONDS);
    }
}
