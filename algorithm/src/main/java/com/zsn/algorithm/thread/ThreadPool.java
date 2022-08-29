package com.zsn.algorithm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : zhou sen nan
 * @Date : 2022/1/18  15:48
 * 线程池测试
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(new Mythread());
        executorService.submit(new Mythread());
        executorService.submit(new Mythread());
        executorService.submit(new Mythread());
        executorService.shutdown();
    }
}

class Mythread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
