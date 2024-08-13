package com.zsn.proxyMode.staticProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:06
 * @Description: description of this class
 * @Version: 1.0
 */
public class TestUseProxy {

    public static void main(String[] args) {
        String send = new ProxySmsServiceImpl(new SmsServiceImpl()).send("hello");

    }
}
