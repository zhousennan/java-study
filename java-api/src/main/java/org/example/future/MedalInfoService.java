package org.example.future;

/**
 * @Author: zsn
 * @Date: 2024/5/14 14:48
 * @Description: description of this class
 * @Version: 1.0
 */
public class MedalInfoService {

   public MedalInfo getMedalInfo(Integer userId) throws InterruptedException {

       Thread.sleep(1000);
        return new MedalInfo(1,userId,"王者");
    }
}
