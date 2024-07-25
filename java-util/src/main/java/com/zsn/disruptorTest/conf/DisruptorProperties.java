package com.zsn.disruptorTest.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  16:20
 */
@ConfigurationProperties(prefix = "disruptor")
public class DisruptorProperties {
    @Value("65536")
    private int ringbufferLength;

    @Value("MUTI")
    private String producerType;

    @Value("Yielding")
    private String waitStrategy;

    @Value("100")
    private int batchSize;

    @Value("500")
    private long interval;

    @Value("2")
    private int retryLimitTimes;

    public int getRingbufferLength() {
        return ringbufferLength;
    }

    public void setRingbufferLength(int ringbufferLength) {
        this.ringbufferLength = ringbufferLength;
    }

    public String getProducerType() {
        return producerType;
    }

    public void setProducerType(String producerType) {
        this.producerType = producerType;
    }

    public String getWaitStrategy() {
        return waitStrategy;
    }

    public void setWaitStrategy(String waitStrategy) {
        this.waitStrategy = waitStrategy;
    }

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

    public int getRetryLimitTimes() {
        return retryLimitTimes;
    }

    public void setRetryLimitTimes(int retryLimitTimes) {
        this.retryLimitTimes = retryLimitTimes;
    }
}
