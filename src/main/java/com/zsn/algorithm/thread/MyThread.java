package com.zsn.algorithm.thread;

/**
 * 线程
 *
 * @Author : zhou sen nan
 * @Date : 2021/9/13  19:50
 */
public class MyThread implements Runnable {
    private String name;       // 表示线程的名称

    public MyThread(String name) {
        this.name = name;      // 通过构造方法配置name属性

    }


    @Override
    public void run() {  // 覆写run()方法，作为线程 的操作主体
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "运行，i = " + i);
        }
    }
}
