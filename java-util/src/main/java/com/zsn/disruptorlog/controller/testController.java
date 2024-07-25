package com.zsn.disruptorlog.controller;

import com.zsn.disruptorTest.bean.TestEvent;
import com.zsn.disruptorTest.bean.User;
import com.zsn.disruptorTest.disruptor.TestDisruptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/23  14:03
 */
@RestController
public class testController {
    @Autowired
    private TestDisruptor disruptor;

    @GetMapping(value = "test1")
    public String test1() {
        System.out.println("test1");
        User user = new User("zsn", "123456", "四川");
        TestEvent testEvent = new TestEvent();
        testEvent.update(user);
        disruptor.push(testEvent);
        return "test1";
    }


    @GetMapping(value = "test2")
    public String test2() {

        return "test1";
    }

    public static void main(String[] args) {
        String words = "hellojava，hello php";
        String newStr = words.replaceAll("hello", "你好 ");
        System.out.println(newStr);
        String s = "809808test0000";
        s = s.replaceAll("test", "all");
        System.out.println(s);
    }

}
