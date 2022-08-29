package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/14  11:00
 */
public class TheadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {

            // Thread.State state = thread.getState();
            //System.out.println("启动后"+state);

            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.State state = thread.getState();
        System.out.println("启动前" + state);

        thread.start();
        state = thread.getState();
        System.out.println("启动后" + state);
        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }


    }
}
