package com.zsn.algorithm.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/17  14:18
 */
public class MyEventFactory implements EventFactory<MyEvent> {
    @Override
    public MyEvent newInstance() {
        return new MyEvent();
    }
}
