package org.example.thread;

/**
 * @Author: zsn
 * @Date: 2024/7/4 15:09
 * @Description: description of this class
 * @Version: 1.0
 */
public class TestStation {


    public static void main(String[] args) {
        //实例化站台对象，并为每一个站台取名字
        Station station1=new Station();
        Station station2=new Station();
        Station station3=new Station();
        // 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();
    }
}
