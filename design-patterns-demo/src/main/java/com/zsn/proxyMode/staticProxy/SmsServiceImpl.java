package com.zsn.proxyMode.staticProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:03
 * @Description: description of this class
 * @Version: 1.0
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public String send(String message) {

        System.out.println("send message:"+ message);
        return "success";
    }
}
