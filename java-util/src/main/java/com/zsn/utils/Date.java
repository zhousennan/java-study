package com.zsn.utils;


import java.time.LocalDate;


/**
 * @Author : zhou sen nan
 * @Date : 2021/12/15  14:03
 */
public class Date {
    public static void main(String[] args) {
       /* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long date2 = System.currentTimeMillis();
        String currentTime2 = dateFormat.format(date2);
        System.out.println(currentTime2);
*/

        nowDateMove(-7);
    }

    public static void nowDateMove(int num) {
        //获取当前日期
        LocalDate ld = LocalDate.now();
        //要移动的天数num，可以是整数或者负数
        LocalDate ll = ld.plusDays(num);
        System.out.println("今天是： " + ld + "------再过" + num + "天是：" + ll);
    }


}
