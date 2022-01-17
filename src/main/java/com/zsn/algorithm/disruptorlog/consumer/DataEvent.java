package com.zsn.algorithm.disruptorlog.consumer;

import com.zsn.algorithm.disruptorlog.bean.ConductAudits;

/**  事件
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:41
 */
public class DataEvent {
    private ConductAudits value;           //ConductAudits为加固中日志对象bean
    public void set(ConductAudits value) {
        this.value = value;
    }
    public ConductAudits getValue() {
        return value;
    }
}
