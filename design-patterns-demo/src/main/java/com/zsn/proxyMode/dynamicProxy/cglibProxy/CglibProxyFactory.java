package com.zsn.proxyMode.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: zsn
 * @Date: 2024/8/7 11:01
 * @Description: description of this class
 * @Version: 1.0
 */
public class CglibProxyFactory {


    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
