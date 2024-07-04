package org.example.thread;


import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @Author: zsn
 * @Date: 2024/7/3 14:07
 * @Description: description of this class
 * @Version: 1.0
 */
public class ThreadPools{

  public static ExecutorService executorService =   Executors.newCachedThreadPool();

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newScheduledThreadPool(1);
        executorService1.execute(()->{
            newThreadPool();
        });

        //executorService1.submit()
    }


    public static void newThreadPool(){
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAliveTime = 1L;
        TimeUnit unit = TimeUnit.MINUTES;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(20);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
        ExecutorService customThreadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler
        );
    }

}
