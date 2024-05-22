package com.zsn.algorithm.disruptor;

/**  事件
 * @Author : zhou sen nan
 * @Date : 2021/11/17  14:15
 */
public class MyEvent {

    private long value;

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MyEvent{" +
                "value=" + value +
                '}';
    }
}
