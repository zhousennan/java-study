package com.zsn.algorithm.disruptorTest.disruptor;

import com.lmax.disruptor.EventTranslator;
import com.zsn.algorithm.disruptorTest.bean.TestEvent;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:36
 */
public class TestEventTranslator implements EventTranslator<TestEvent> {
    private ThreadLocal<TestEvent> threadLocal = new ThreadLocal<>();

    @Override
    public void translateTo(TestEvent testEvent, long l) {
        System.out.println("translateTo");
        TestEvent date = getTestEvent();
        testEvent.update(date.getUser());
    }

    public void addQueue(TestEvent event){
        System.out.println("addQueue");
        TestEvent testEvent = getTestEvent();
        testEvent.update(event.getUser());
    }

    private TestEvent getTestEvent() {
        System.out.println("TestEvent");
        TestEvent event = threadLocal.get();
        if (null == event) {
            event = new TestEvent();
            threadLocal.set(event);
        }
        return event;
    }
}
