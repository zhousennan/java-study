package com.zsn.proxyMode.dynamicProxy.jdkProxy;

/**
 * @Author: zsn
 * @Date: 2024/8/7 10:49
 * @Description: description of this class
 * @Version: 1.0
 */
public class PayServiceImpl implements PayService {
    @Override
    public String pay(String message) {

        System.out.println(" 我支付的了："+message);
        return null;
    }
}
