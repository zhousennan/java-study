package com.zsn.shiro.controller;

import com.zsn.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:17
 */
@Controller
public class UserController {


    @PostMapping(value = "/index")
    public String index(@RequestBody User user){

        Subject subject = SecurityUtils.getSubject();

        //封装前端提交的用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);//执行登录方法，执行成功就跳转主页面
            return "home";
            //捕获可能出现的异常
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "home";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/goindex")
    public String index(){
        return "home";
    }
}
