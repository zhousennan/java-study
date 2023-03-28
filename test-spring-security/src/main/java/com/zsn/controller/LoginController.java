package com.zsn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public String login(){
        return "登录成功";
    }

    @GetMapping(value = "/index")
    public String index(){
        return "进入首页";
    }



}


