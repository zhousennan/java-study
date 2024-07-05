package com.zsn.singleDemo;

/**
 * @Author: zsn
 * @Date: 2024/7/5 10:54
 * @Description: 懒汉式（线程不安全）
 * @Version: 1.0
 */
public class SingleDemo1 {

    private static SingleDemo1 singleDemo1;

    private SingleDemo1()
    {
    }

    public static SingleDemo1 getInstance()
    {
        if (singleDemo1 == null)
        {
            singleDemo1 = new SingleDemo1();
        }
        return singleDemo1;
    }
}
