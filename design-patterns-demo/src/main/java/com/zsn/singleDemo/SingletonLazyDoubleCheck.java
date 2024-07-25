package com.zsn.singleDemo;

/**
 * @Author: zsn
 * @Date: 2024/7/5 11:14
 * @Description: 双重检查锁定
 * @Version: 1.0
 */
public class SingletonLazyDoubleCheck {

    private static SingletonLazyDoubleCheck singletonLazyDoubleCheck;

    private SingletonLazyDoubleCheck() {
    }


    public static SingletonLazyDoubleCheck getInstance() {
        if (singletonLazyDoubleCheck == null) {
            synchronized (SingletonLazyDoubleCheck.class) {
                if (singletonLazyDoubleCheck == null) {
                    singletonLazyDoubleCheck = new SingletonLazyDoubleCheck();
                }
            }
        }
        return singletonLazyDoubleCheck;
    }
}
