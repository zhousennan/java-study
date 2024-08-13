package com.zsn.proxyMode.dynamicProxy.jdkProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:32
 * @Description: description of this class
 * @Version: 1.0
 */
public class SnsServiceOk implements SmsService{
    @Override
    public String send(String message) {


        System.out.println("SnsServiceOk send message:" + message);
        return null;
    }
}
