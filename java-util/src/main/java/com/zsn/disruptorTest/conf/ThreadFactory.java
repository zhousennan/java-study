package com.zsn.disruptorTest.conf;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/17  15:24
 */
public class ThreadFactory implements java.util.concurrent.ThreadFactory {
    private AtomicInteger index = new AtomicInteger(1);
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"testDisruptorThread-"+index.getAndIncrement());
    }
}
