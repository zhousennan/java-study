package com.zsn.algorithm.thread;

/**
 * @Author : zhou sen nan
 * @Date : 2021/10/14  10:50
 */
public class Join  implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("I  am Join"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Join join = new Join();
        Thread thread = new Thread(join);

        thread.start();
        for (int i = 0; i < 500; i++) {

            if (i==250){
                thread.join();
            }
            System.out.println("main  thread"+i);

        }
    }


}
