package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/12  15:42
 * 龟兔赛跑
 */
public class TestThread02 implements Runnable {
    private static String owner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (Thread.currentThread().getName()=="兔子"){
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean b = isBlooen(i);
            if (b) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了多少" + i + "步");

        }

    }

    private Boolean isBlooen(int step) {
        if (owner != null) {
            return true;
        } else {
            if (step >= 100) {
                owner = Thread.currentThread().getName();
                System.out.println("胜利者是" + owner);
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        TestThread02 testThread02 = new TestThread02();
        new Thread(testThread02, "兔子").start();
        new Thread(testThread02, "乌龟").start();
    }
}
