package com.zsn.singleDemo;

/**
 * @Author: zsn
 * @Date: 2024/7/5 10:56
 * @Description: 饿汉式
 * @Version: 1.0
 */
public class SingleDemo2 {
    private static SingleDemo2 singleDemo2 = new SingleDemo2();

    private SingleDemo2() {

    }

    public static SingleDemo2 getSingleDemo2() {

        return singleDemo2;

    }


}
