package com.zsn.algorithm.deadlock;

import com.zsn.algorithm.deadlock.account.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/30  14:44
 */
public class DeadLockThread extends Thread {

    LeftRightDeadLock leftRightDeadLock;

    public DeadLockThread(LeftRightDeadLock leftRightDeadLock) {
        this.leftRightDeadLock = leftRightDeadLock;
    }

    @Override
    public void run() {
        //LeftRightDeadLock leftRightDeadLock = new LeftRightDeadLock();
        leftRightDeadLock.leftToRight();
        leftRightDeadLock.rightToLeft();
    }

    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();
        Account account1 = new Account("1");
        Account account2 = new Account("2");
        Account account3 = new Account("3");

        list.add(account1);
        list.add(account2);
        list.add(account3);
        System.out.println(account1);
        System.out.println(list.toString());
    }
}
