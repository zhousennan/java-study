package org.example.completableFuture;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zsn
 * @Date: 2024/5/14 16:47
 * @Description: description of this class
 * @Version: 1.0
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        Thread thread = new Thread(()->{
            System.out.println("Thread is running");
        });
        thread.start();

        CompletableFuture<Integer> futureSquare = CompletableFuture.supplyAsync(() -> {
            try {
                return calculateSquare(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("=====");
        CompletableFuture<Integer> futureCube = futureSquare.thenApply(square -> calculateCube(square));

        System.out.println("sssssss");
        futureCube.get(6000, TimeUnit.MILLISECONDS);
        futureCube.thenAccept(System.out::println); 
    }

    private static int calculateSquare(int num) throws InterruptedException {
        System.out.println("Calculating square of " + num);
        Thread.sleep(5000);
        return num * num;
    }

    private static int calculateCube(int num) {
        System.out.println("Calculating cube of " + num);
        return num * num * num;
    }

}
