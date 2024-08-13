package com.zsn.proxyMode.dynamicProxy.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:25
 * @Description: description of this class
 * @Version: 1.0
 */
public class JdkProxyFactory {

    public static   Object getProxy(Object object){


      return  Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),new SmsJdkProxyServiceImpl(object));

    }
}
