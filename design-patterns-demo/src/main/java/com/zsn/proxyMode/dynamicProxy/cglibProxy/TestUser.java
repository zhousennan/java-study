package com.zsn.proxyMode.dynamicProxy.cglibProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 11:02
 * @Description: description of this class
 * @Version: 1.0
 */
public class TestUser {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("java");
    }
}
