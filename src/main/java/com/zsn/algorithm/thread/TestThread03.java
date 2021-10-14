package com.zsn.algorithm.thread;


import java.sql.CallableStatement;
import java.util.concurrent.*;

;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/12  16:22
 * 实现runnable
 */
public class TestThread03 implements Callable<Boolean> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        TestThread03 test = new TestThread03();
        TestThread03 testThread2 = new TestThread03();
        //创建提交服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
       //提交执行
        Future<Boolean> submit1 = executorService.submit(test);
        Future<Boolean> submit2 = executorService.submit(testThread2);
        //获取结果
        submit1.get();
        submit2.get();
        //关闭服务
        executorService.shutdownNow();
    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程" + Thread.currentThread().getName());
        }
        return true;
    }
}
