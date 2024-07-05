package com.zsn.singleDemo;

/**
 * @Author: zsn
 * @Date: 2024/7/5 11:09
 * @Description: 懒汉式（加一个锁 - 简单同步方法）
 * @Version: 1.0
 */
public class SingletonLazySimpleSync {
    private static SingletonLazySimpleSync instance;

    private SingletonLazySimpleSync() {
    }

    public static synchronized SingletonLazySimpleSync getInstance() {
        if (instance == null) {
            instance = new SingletonLazySimpleSync();
        }
        return instance;
    }
}
