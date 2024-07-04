package org.example.thread;

import java.util.concurrent.Semaphore;

/**
 * @Author: zsn
 * @Date: 2024/7/3 16:58
 * @Description: 线程交替打印 a b  c
 * @Version: 1.0
 */
public class ABCPrinter {


    public final Semaphore A = new Semaphore(1);
    public final Semaphore B = new Semaphore(0);
    public final Semaphore C = new Semaphore(0);

    private int max;

    public ABCPrinter(int max) {
        this.max = max;
    }

    private void printA() {

        print("A",A,B);
    }
    private void printB() {

        print("B",B,C);
    }
    private void printC() {
        print("C",C,A);
    }

    public void print(String s ,Semaphore semaphore,Semaphore nextSemaphore) {


        for (int i = 0; i < max; i++) {
            try {
                semaphore.acquire();
                System.out.println(s);
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ABCPrinter printer = new ABCPrinter(10);
        Thread t1 = new Thread(printer::printA, "Thread A");
        Thread t2 = new Thread(printer::printB, "Thread B");
        Thread t3 = new Thread(printer::printC, "Thread C");

        t1.start();
        t2.start();
        t3.start();
    }


}
