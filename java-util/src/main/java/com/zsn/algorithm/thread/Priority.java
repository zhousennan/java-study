package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/14  11:36
 */
public class Priority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        Priority priority = new Priority();
        Thread thread1 = new Thread(priority);
        Thread thread2 = new Thread(priority);
        Thread thread3 = new Thread(priority);
        Thread thread4 = new Thread(priority);
        Thread thread5 = new Thread(priority);
        thread1.start();
       thread2.setPriority(1);
        thread2.start();
       thread3.setPriority(5);
        thread4.setPriority(Thread.MAX_PRIORITY);
       thread3.start();
       thread4.start();
      thread5.setPriority(Thread.MIN_PRIORITY);
       thread5.start();
    }
}
