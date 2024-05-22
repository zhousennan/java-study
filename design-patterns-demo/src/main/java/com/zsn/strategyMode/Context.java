package com.zsn.strategyMode;

/**
 * @Author: zsn
 * @Date: 2024/2/6 11:00
 * @Description: TODO Description of this class
 * @Version: 1.0
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
