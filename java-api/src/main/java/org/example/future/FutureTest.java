package org.example.future;

import java.util.concurrent.*;

/**
 * @Author: zsn
 * @Date: 2024/5/14 14:36
 * @Description: description of this class
 * @Version: 1.0
 */
public class FutureTest {



    private  static ExecutorService executorService = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Integer userId = 1;
        UserService userInfoService = new UserService();
        MedalInfoService medalService = new MedalInfoService();
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);

        FutureTask<User> userFutureTask = new FutureTask<>(new Callable<User>() {
            @Override
            public User call() throws Exception {
                return userInfoService.getUserInfo(userId);
            }
        });

        executorService.submit(userFutureTask);
        Thread.sleep(2000);


        FutureTask<MedalInfo> medalFutureTask = new FutureTask<>(new Callable<MedalInfo>() {
            @Override
            public MedalInfo call() throws Exception {
                return medalService.getMedalInfo(userId);
            }
        });
        executorService.submit(medalFutureTask);

        User user = userFutureTask.get();
        System.out.println(user.toString());
        MedalInfo medalInfo = medalFutureTask.get();
        medalFutureTask.isDone();
        System.out.println(medalInfo.toString());
        long end = System.currentTimeMillis();

        System.out.println(end - startTime);
    }
}