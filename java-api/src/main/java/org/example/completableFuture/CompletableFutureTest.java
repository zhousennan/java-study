package org.example.completableFuture;


import org.example.future.MedalInfo;
import org.example.future.MedalInfoService;
import org.example.future.User;
import org.example.future.UserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: zsn
 * @Date: 2024/5/14 16:00
 * @Description: description of this class
 * @Version: 1.0
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        UserService userInfoService = new UserService();
        MedalInfoService medalService = new MedalInfoService();

        Long startTIme =System.currentTimeMillis();
        CompletableFuture<User> userCompletableFuture =CompletableFuture.supplyAsync(() -> {
            try {
                return userInfoService.getUserInfo(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(300);
        CompletableFuture<MedalInfo> medalInfoCompletableFuture =CompletableFuture.supplyAsync(() -> {
            try {
                return medalService.getMedalInfo(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        User user = userCompletableFuture.get();



        MedalInfo medalInfo = medalInfoCompletableFuture.get();
        Long endTime =System.currentTimeMillis();
        System.out.println(endTime-startTIme);
    }
}
