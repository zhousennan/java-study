package com.zsn.disruptorTest.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.ExceptionHandler;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import com.zsn.disruptorTest.bean.TestEvent;
import com.zsn.disruptorTest.conf.EventFactory;
import com.zsn.disruptorTest.conf.ThreadFactory;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:33
 */
public class TestDisruptor implements AbstractDisruptor<TestEvent> {
    private Disruptor<TestEvent> disruptor;
    private final TestEventTranslator translator = new TestEventTranslator();
    @Override
    public void init(int ringbufferLength, ProducerType producerType, WaitStrategy waitStrategy) {
        disruptor =  new Disruptor<>(new EventFactory(),ringbufferLength,new ThreadFactory(),producerType,waitStrategy);
        disruptor.setDefaultExceptionHandler(new ExceptionHandler<TestEvent>() {
            @Override
            public void handleEventException(Throwable throwable, long l, TestEvent event) {

            }

            @Override
            public void handleOnStartException(Throwable throwable) {

            }

            @Override
            public void handleOnShutdownException(Throwable throwable) {

            }
        });
    }

    @Override
    public void start() {
    this.disruptor.start();
    }

    @Override
    public boolean push(TestEvent event) {
        translator.addQueue(event);
        disruptor.publishEvent(translator);
        return true;
    }

    @Override
    public EventHandlerGroup<TestEvent> addHandler(EventHandler<TestEvent> eventHandler) {
        return disruptor.handleEventsWith(eventHandler);
    }
}
