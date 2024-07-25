package com.zsn.shiro.controller;

import com.zsn.shiro.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : zhou sen nan
 * @Date : 2022/9/26  16:38
 */
@RestController
public class TestController {
    @PostMapping("test")
    public String test(@RequestBody User user){

        System.out.println(user.toString());
        return "sssssssssss";
    }
}
