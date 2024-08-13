package com.zsn.proxyMode.dynamicProxy.jdkProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:30
 * @Description: description of this class
 * @Version: 1.0
 */
public class TestProxy {

    public static void main(String[] args) {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        SmsService ok = (SmsService) JdkProxyFactory.getProxy(new SnsServiceOk());
        PayService pay = (PayService) JdkProxyFactory.getProxy(new PayServiceImpl());
        proxy.send("hello");
        ok.send("ok 不 OK");
        pay.pay("8$");
    }
}
