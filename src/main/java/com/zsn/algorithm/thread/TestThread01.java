package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/12  15:25
 */
public class TestThread01 implements Runnable {
    private static int tick = 10;

    @Override
    public void run() {
        while (tick > 0) {

            System.out.println(Thread.currentThread().getName() + "拿到第几张票" + tick);
            tick = --tick;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestThread01 testThread01 = new TestThread01();
        new Thread(testThread01, "小米").start();
        new Thread(testThread01, "老师 ").start();
        new Thread(testThread01, "黄牛").start();
    }
}
