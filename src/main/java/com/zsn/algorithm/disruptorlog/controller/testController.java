package com.zsn.algorithm.disruptorlog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/23  14:03
 */
@RestController
public class testController {
    @GetMapping(value = "test1")
    public String test1(){
        return "test1";
    }


    @GetMapping(value = "test2")
    public String test2(){

        return "test1";
    }

    public static void main(String[] args) {
        String words = "hellojava，hello php";
        String newStr = words.replaceAll("hello","你好 ");
        System.out.println(newStr);
        String s="809808test0000";
       s= s.replaceAll("test","all");
        System.out.println(s);
    }

}
