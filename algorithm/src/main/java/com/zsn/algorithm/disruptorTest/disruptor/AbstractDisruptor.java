package com.zsn.algorithm.disruptorTest.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:29
 */
public interface AbstractDisruptor<T> {
    void init(int ringbufferLength, ProducerType producerType, WaitStrategy waitStrategy);

    void start();

    boolean push(T event);

    EventHandlerGroup<T> addHandler(EventHandler<T> eventHandler);
}
