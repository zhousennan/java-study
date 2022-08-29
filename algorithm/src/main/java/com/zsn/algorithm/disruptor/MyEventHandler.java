package com.zsn.algorithm.disruptor;


import com.lmax.disruptor.EventHandler;

/**  消费者
 * @Author : zhou sen nan
 * @Date : 2021/11/17  14:21
 */
public class MyEventHandler implements EventHandler<MyEvent> {


    @Override
    public void onEvent(MyEvent myEvent, long l, boolean b) throws Exception {
        System.out.println(myEvent);
    }
}
