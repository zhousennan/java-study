package com.zsn.strategyMode;

/**
 * @Author: zsn
 * @Date: 2024/2/6 10:58
 * @Description: TODO Description of this class
 * @Version: 1.0
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1+num2;
    }
}
