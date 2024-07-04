package org.example.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zsn
 * @Date: 2024/7/4 15:09
 * @Description:
 * 目前有三个窗口同时出售20张票，需要你在右侧代码中的 Begin-End区域编写代码实现多个窗口售票的功能，具体要求如下：
 * • 票数要使用同一个静态值；
 * • 为保证不会出现卖出同一张票，使用java多线程同步锁（synchronized或lock）。
 * 解题思路：
 * 创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作（即如果票没卖完就一直卖）！售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完！
 * @Version: 1.0
 */
public class Station extends Thread{
    private static int ticket = 20;
    private static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {

        while (ticket>0){
            lock.lock();
            try {
                if (ticket>0){
                    System.out.println("卖出第："+ticket+"票");
                    ticket--;
                }
            }finally {
                lock.unlock();
            }
        }

    }
}
