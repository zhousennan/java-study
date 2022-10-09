package com.zsn.shiro.controller;

import com.zsn.shiro.entity.User;
import com.zsn.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:17
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param user 用户信息
     * @return String 登录信息
     */
    @PostMapping(value = "/login")
    public String userLogin(@RequestBody User user) {

        Subject subject = SecurityUtils.getSubject();

        //封装前端提交的用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            //执行登录方法
            subject.login(token);
            return "登录成功";
            //捕获可能出现的异常
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "用户名错误";
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return ("密码错误");
        }
    }

    /**
     * 用户注册
     * @param user 用户信息
     * @return String 返回信息
     */
    @PostMapping(value = "/register")
    public String userRegister(@RequestBody User user) {

        try {
            userService.register(user);
            return "注册成功";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("=============注册失败");
            return "注册失败";
        }


    }


}
