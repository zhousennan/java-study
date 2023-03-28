package com.zsn.algorithm.disruptorTest.conf;

import com.lmax.disruptor.dsl.ProducerType;
import com.zsn.algorithm.disruptorTest.disruptor.TestDisruptor;
import com.zsn.algorithm.disruptorTest.handler.TestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  16:26
 */
@Configuration
@EnableCaching
@EnableConfigurationProperties({DisruptorProperties.class})
public class DisruptorConfiguration {

    @Autowired
    private DisruptorProperties disruptorProperties;

    @Bean
    public TestDisruptor newTestDisruptor() {
        TestDisruptor testDisruptor = new TestDisruptor();
        ProducerType producerType = null;
        if (disruptorProperties.getProducerType().equals("MULTI")) {
            producerType = ProducerType.MULTI;
        } else {
            producerType = ProducerType.SINGLE;
        }
        System.out.println("====开始初始化 disruptor====");
        testDisruptor.init(disruptorProperties.getRingbufferLength(), producerType, getWaitStrategy(disruptorProperties.getWaitStrategy()));
        System.out.println("====初始化成功 disruptor====");
        testDisruptor.addHandler(testDisruptorConsumer());
        System.out.println("====开始启动disruptor====");
        testDisruptor.start();
        System.out.println("====启动成功disruptor====");
        return testDisruptor;
    }

    private WaitStrategy getWaitStrategy(String watStrategy) {
        switch (watStrategy) {
            case "Blocking":
                return new BlockingWaitStrategy();
            case "BusySpin":
                return new BusySpinWaitStrategy();
            case "PhasedBackoff":
                return new PhasedBackoffWaitStrategy(500, 3000, TimeUnit.MILLISECONDS, new SleepingWaitStrategy());
            case "Sleeping":
                return new SleepingWaitStrategy();
            case "TimeoutBlocking":
                return new TimeoutBlockingWaitStrategy(1000, TimeUnit.MILLISECONDS);
            case "Yidlding":
                return new YieldingWaitStrategy();
            default:
                return new SleepingWaitStrategy();
        }
    }

    @Bean("testEvent")
    @Qualifier("testDisruptor")
    @ConditionalOnMissingBean
    public TestHandler testDisruptorConsumer() {
        TestHandler testDisruptor = new TestHandler(disruptorProperties.getBatchSize(), disruptorProperties.getInterval(), disruptorProperties.getRetryLimitTimes());

        return testDisruptor;
    }
}
