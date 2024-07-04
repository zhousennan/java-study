package org.example.thread;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: zsn
 * @Date: 2024/7/3 14:58
 * @Description: description of this class
 * @Version: 1.0
 */
public class ThreadPrint {
    public void joinThread() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(2);

            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(3);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public static void CompletableFutureTest2() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // T1
        CompletableFuture<Void> futureT1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1 is executing.Current time：" + DateUtil.now()+"  threadName:"+Thread.currentThread().getName());
            // 模拟耗时操作
            ThreadUtil.sleep(1000);
        },executorService);

            // T2 在 T1 完成后执行
        CompletableFuture<Void> futureT2 = futureT1.thenRunAsync(() -> {
            System.out.println("T2 is executing after T1.Current time：" + DateUtil.now()+"  threadName:"+Thread.currentThread().getName());
            ThreadUtil.sleep(1000);
        },executorService);

        // T3 在 T2 完成后执行
        CompletableFuture<Void> futureT3 = futureT2.thenRunAsync(() -> {
            System.out.println("T3 is executing after T2.Current time：" + DateUtil.now()+"  threadName:"+Thread.currentThread().getName());
            ThreadUtil.sleep(1000);
        },executorService);

        // 等待所有任务完成，验证效果
        ThreadUtil.sleep(3000);

    }

    public static void main(String[] args) {
        CompletableFutureTest2();
    }
}
