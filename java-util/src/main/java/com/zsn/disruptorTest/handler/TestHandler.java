package com.zsn.disruptorTest.handler;

import com.lmax.disruptor.EventHandler;
import com.zsn.disruptorTest.bean.TestEvent;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  16:46
 */
public class TestHandler implements EventHandler<TestEvent> {
    /**
     * 批处理数量
     */
    private int batchSize;
    /**
     * 推送时间间隔
     */
    private long interval;

    /**
     * 重试次数限制
     */
    private int retryLimit;

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public long getInterval() {
        return interval;
    }

    public void setInterval(long interval) {
        this.interval = interval;
    }

    public int getRetryLimit() {
        return retryLimit;
    }

    public void setRetryLimit(int retryLimit) {
        this.retryLimit = retryLimit;
    }

    public TestHandler(int batchSize, long interval, int retryLimit) {
        this.batchSize = batchSize;
        this.interval = interval;
        this.retryLimit = retryLimit;
    }

    @Override
    public void onEvent(TestEvent event, long l, boolean b) throws Exception {
        System.out.println(event.getUser());
    }
}
