package com.zsn.algorithm.disruptorlog.consumer;

import com.lmax.disruptor.EventHandler;
import com.zsn.algorithm.disruptorlog.bean.ConductAudits;

/**
 * 消费者
 *
 * @Author : zhou sen nan
 * @Date : 2021/11/22  14:52
 */
public class LogBatchHandler implements EventHandler<DataEvent> {
    @Override
    public void onEvent(DataEvent dataEvent, long l, boolean b) throws Exception {
        //数据批量入库
        if (dataEvent != null) {
            batchSaveLog(dataEvent.getValue());
        }
    }

    /**
     * 批量存储日志
     */
    private void batchSaveLog(ConductAudits conductAudits) {
        System.out.println(conductAudits);
    }
}
