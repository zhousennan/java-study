package com.zsn.proxyMode.staticProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:04
 * @Description: description of this class
 * @Version: 1.0
 */
public class ProxySmsServiceImpl implements SmsService{

    private SmsService smsService;
    public ProxySmsServiceImpl(SmsService smsService) {
        this.smsService = smsService;
    }
    @Override
    public String send(String message) {

        //调用前
        System.out.println("调用前");
        String send = smsService.send(message);
        //调用后
        System.out.println("调用后");

        return send;
    }
}
