package com.zsn.strategyMode;

/**
 * @Author: zsn
 * @Date: 2024/2/6 10:57
 * @Description: TODO Description of this class
 * @Version: 1.0
 */
public interface Strategy {
    /**
     * 执行策略
     * @param num1
     * @param num2
     * @return
     */
    public int doOperation(int num1, int num2);
}
