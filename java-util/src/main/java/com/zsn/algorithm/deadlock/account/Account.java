package com.zsn.algorithm.deadlock.account;

import java.math.BigDecimal;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/30  17:02
 */
public class Account {

    /** 账户 */
    public String number;
    /** 余额 */
    public BigDecimal balance;
    public Account(String number) {
        this.number = number;

    }

    @Override
    public String toString() {
        return "{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
