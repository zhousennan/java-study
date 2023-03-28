package com.zsn.algorithm.deadlock.account;

import java.math.BigDecimal;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/30  17:18
 */
public class TransferMoneyOptimize {

    /** hash 冲突时使用第三个锁(优秀的hash算法冲突是很少的！) */
    private static final Object conflictShareLock = new Object();

    /**
     * 转账方法
     *
     * @param accountFrom       转账方
     * @param accountTo         接收方
     * @param amt               转账金额
     * @throws Exception
     */
    public static void transferMoney(Account accountFrom,
                                     Account accountTo,
                                     BigDecimal amt) throws Exception {
        // 计算hash值
        int accountFromHash = System.identityHashCode(accountFrom);
        int accountToHash = System.identityHashCode(accountTo);
        // 如下三个分支能一定控制账户之间的转是不会产生死锁的
        if (accountFromHash > accountToHash) {
            synchronized (accountFrom) {
                synchronized (accountTo) {
                    transferMoneyHandler(accountFrom, accountTo, amt);
                }
            }
        } else if (accountToHash > accountFromHash) {
            synchronized (accountTo) {
                synchronized (accountFrom) {
                    transferMoneyHandler(accountFrom, accountTo, amt);
                }
            }
        } else {
            // 解决hash冲突
            synchronized (conflictShareLock) {
                synchronized (accountFrom) {
                    synchronized (accountTo) {
                        transferMoneyHandler(accountFrom, accountTo, amt);
                    }
                }
            }
        }

    }

    /**
     * 账户金额增加处理
     *
     * @param accountFrom       转账方
     * @param accountTo         接收方
     * @param amt               转账金额
     * @throws Exception
     */
    private static void transferMoneyHandler(Account accountFrom,
                                             Account accountTo,
                                             BigDecimal amt) throws Exception {
        if (accountFrom.balance.compareTo(amt) < 0) {
            throw new Exception(accountFrom.number + " balance is not enough.");
        } else {
            accountFrom.setBalance(accountFrom.balance.subtract(amt));
            accountTo.setBalance(accountTo.balance.add(amt));
            System.out.println("Form" + accountFrom.number + ": " + accountFrom.balance.toPlainString()
                    +"\t" + "To" +  accountTo.number + ": " + accountTo.balance.toPlainString());
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
