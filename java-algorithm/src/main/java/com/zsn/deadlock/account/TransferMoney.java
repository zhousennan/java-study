package com.zsn.deadlock.account;

import java.math.BigDecimal;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/30  17:03
 */
public class TransferMoney {
    /**
     * 转账方法
     *
     * @param accountFrom 转账方
     * @param accountTo   接收方
     * @param amt         转账金额
     * @throws Exception
     */
    public static void transferMoney(Account accountFrom,
                                     Account accountTo,
                                     BigDecimal amt) throws Exception {

        synchronized (accountFrom) {
            synchronized (accountTo) {
                BigDecimal formBalance = accountFrom.balance;
                if (formBalance.compareTo(amt) < 0) {
                    throw new Exception(accountFrom.number + " balance is not enough.");
                } else {
                    accountFrom.setBalance(formBalance.subtract(amt));
                    accountTo.setBalance(accountTo.balance.add(amt));
                    System.out.println("Form" + accountFrom.number + ": " + accountFrom.balance.toPlainString()
                            + "\t" + "To" + accountTo.number + ": " + accountTo.balance.toPlainString());
                }
            }
        }
    }

    public static void main(String[] args) {
        // 账户A && 账户B
        Account accountA = new Account("111111", new BigDecimal(10000));
        Account accountB = new Account("2222222", new BigDecimal(10000));
        // 循环创建线程 A -> B ; B -> A 各一百个线程
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    // 转账顺序 A -> B
                    transferMoney(accountA, accountB, new BigDecimal(10));
                } catch (Exception e) {
                    return;
                }
            }).start();

            new Thread(() -> {
                try {
                    // 转账顺序 B -> A
                    transferMoney(accountB, accountA, new BigDecimal(10));
                } catch (Exception e) {
                    return;
                }
            }).start();
        }

    }
}
