package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/14  10:39
 */
public class Yield implements Runnable {
    @Override
    public void run() {
        System.out.println("start" + Thread.currentThread().getName());
        Thread.yield();
        System.out.println("end" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Yield yield = new Yield();

        new Thread(yield, "a").start();

        new Thread(yield, "b").start();

    }
}
