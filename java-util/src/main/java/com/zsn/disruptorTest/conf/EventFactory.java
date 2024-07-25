package com.zsn.disruptorTest.conf;

import com.zsn.disruptorTest.bean.TestEvent;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:22
 * 定义event 事件处理工厂
 */
public class EventFactory implements com.lmax.disruptor.EventFactory<TestEvent> {
    @Override
    public TestEvent newInstance() {
        return new TestEvent();
    }
}
