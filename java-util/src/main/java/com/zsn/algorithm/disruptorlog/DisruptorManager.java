package com.zsn.algorithm.disruptorlog;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.zsn.algorithm.disruptorlog.bean.ConductAudits;
import com.zsn.algorithm.disruptorlog.consumer.DataEvent;
import com.zsn.algorithm.disruptorlog.consumer.DataEventFactory;
import com.zsn.algorithm.disruptorlog.consumer.LogBatchHandler;
import com.zsn.algorithm.disruptorlog.producer.EventProducer;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:48
 */
public class DisruptorManager {


    public static void main(String[] args) {
        //建立默认线程工厂，提供线程来处理consumer触发的事件处理
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        EventFactory<DataEvent> dataEventFactory = new DataEventFactory();

        int ringBufferSize = 16;
        //Disruptor底层数据结构实现，核心类，是线程间交换数据的中转地
        // private static RingBuffer<DataEvent> ringBuffer;

        Disruptor<DataEvent> disruptor = new Disruptor<DataEvent>(dataEventFactory,
                ringBufferSize,
                threadFactory,
                ProducerType.SINGLE,
                new YieldingWaitStrategy());
//消费者
        disruptor.handleEventsWith(new LogBatchHandler());

        disruptor.start();


        //------------------生产数据------------
        RingBuffer<DataEvent> ringBuffer = disruptor.getRingBuffer();

        EventProducer eventProducer = new EventProducer(ringBuffer);

        //生产数据
        for (int i = 0; i < 100; i++) {
            eventProducer.onData(new ConductAudits(i, i + 1, "zsn" + i));
        }


        disruptor.shutdown();
    }


}
