package com.zsn.algorithm.thread.syn;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/21  15:30
 */
public class UserByTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"小米").start();
        new Thread(ticket,"测试").start();
        new Thread(ticket,"票贩子").start();
    }
}

class  Ticket implements Runnable{
private int ticketNums = 10;
boolean  flag = true;
    @Override
    public void run() {
        while    (flag){

            buy();
        }
    }
    public synchronized void buy(){
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticketNums>0){
            System.out.println(Thread.currentThread().getName()+"买了第"+ticketNums--);
        }else
            flag=false;

    }
}
