package com.zsn.disruptorlog.consumer;

import com.lmax.disruptor.EventFactory;

/**  工厂
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:42
 */
public class DataEventFactory implements EventFactory<DataEvent> {
    @Override
    public DataEvent newInstance() {
        return new DataEvent();
    }
}
