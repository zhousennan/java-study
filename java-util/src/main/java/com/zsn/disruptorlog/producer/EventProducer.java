package com.zsn.disruptorlog.producer;

import com.lmax.disruptor.RingBuffer;
import com.zsn.disruptorlog.bean.ConductAudits;
import com.zsn.disruptorlog.consumer.DataEvent;

/**  生产者
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:45
 */
public class EventProducer {
    private RingBuffer<DataEvent> ringBuffer;

    public EventProducer(RingBuffer<DataEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    /**
     * 生产事件  向环行数组放数据
     */
    public void onData(ConductAudits conductAudits) {
        long next = ringBuffer.next();
        try {
            DataEvent myEvent = ringBuffer.get(next);
            myEvent.set(conductAudits);
        } finally {
            ringBuffer.publish(next);
        }
    }
}
