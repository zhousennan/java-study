//package com.zsn.algorithm.deadlock;
//
//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.poi.excel.ExcelUtil;
//import cn.hutool.poi.excel.ExcelWriter;
//
//import java.util.List;
//
///**
// * @Author : zhou sen nan
// * @Date : 2021/11/9  19:25
// */
//public class test {
//    public static void main(String[] args) {
//        TestBean bean1 = new TestBean();
//        bean1.setName("张三");
//        bean1.setAge(22);
//        bean1.setPass(true);
//        bean1.setScore(66.30);
//
//        TestBean bean2 = new TestBean();
//        bean2.setName("李四");
//        bean2.setAge(28);
//        bean2.setPass(false);
//        bean2.setScore(38.50);
//
//        List<TestBean> rows = CollUtil.newArrayList(bean1, bean2);
//
//        // 通过工具类创建writer
//        ExcelWriter writer = ExcelUtil.getWriter("d:/writeBeanTest.xlsx");
//// 合并单元格后的标题行，使用默认标题样式
//        writer.merge(4, "一班成绩单");
//// 一次性写出内容，使用默认样式，强制输出标题
//        writer.write(rows, true);
//// 关闭writer，释放内存
//        writer.close();
//    }
//}
