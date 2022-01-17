package com.zsn.algorithm.deadlock;

import java.sql.Time;

/**
 * <p>
 * 顺序死锁
 * </p>
 * <p>
 * 死锁产生的条件
 * 死锁的产生有四个必要的条件
 * <p>
 * 互斥使用，即当资源被一个线程占用时，别的线程不能使用
 * 不可抢占，资源请求者不能强制从资源占有者手中抢夺资源，资源只能由占有者主动释放
 * 请求和保持，当资源请求者在请求其他资源的同时保持对原因资源的占有
 * 循环等待，多个线程存在环路的锁依赖关系而永远等待下去，例如T1占有T2的资源，T2占有T3的资源，T3占有T1的资源，这种情况可能会形成一个等待环路
 *
 * @Author : zhou sen nan
 * @Date : 2021/10/30  14:34
 */
public class LeftRightDeadLock {
    private final Object right = new Object();
    private final Object left = new Object();

    /**
     * 加锁顺序从left -> right
     */
    public void leftToRight() {
        synchronized (left) {
            synchronized (right) {

                System.out.println(Thread.currentThread().getName() + " left -> right lock.");
            }
        }
    }

    /**
     * 加锁顺序right -> left
     */
    public void rightToLeft() {
        synchronized (right) {
            synchronized (left) {
                System.out.println(Thread.currentThread().getName() + " right -> left lock.");
            }
        }
    }

    public static void main(String[] args) {
        LeftRightDeadLock lrDeadLock = new LeftRightDeadLock();
        DeadLockThread deadLockThread = new DeadLockThread(lrDeadLock);
        for (int i = 0; i < 100; i++) {
       /*    new Thread(() -> {
        // 为了更好的演示死锁，将两个方法的调用放置到同一个线程中执行
               lrDeadLock.leftToRight();
               lrDeadLock.rightToLeft();
            }, "ThreadA-"+i).start();*/
            new Thread(deadLockThread, "T" + i).start();
        }
    }
// cmd jps
// jstack
    //解决顺序死锁的办法其实就是保证所有线程以相同的顺序获取锁就行。
}
