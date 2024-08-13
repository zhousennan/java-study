package com.zsn.proxyMode.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:20
 * @Description: description of this class
 * @Version: 1.0
 */
public class SmsJdkProxyServiceImpl implements InvocationHandler {

    private final  Object target;
    public SmsJdkProxyServiceImpl(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


        System.out.println("before");

        Object invoke = method.invoke(target, args);
        System.out.println("after");
        return invoke;
    }
}
