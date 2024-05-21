package com.sharding.jdbc.controller;

import com.sharding.jdbc.pojo.User;
import com.sharding.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zsn
 * @Date: 2024/5/20 16:27
 * @Description: description of this class
 * @Version: 1.0
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUserById")
    public User getUserById(@RequestParam("id") Long id) {
        return userService.getUserById(id);
    }


    @PostMapping("save")
    public void saveUser(@RequestBody User user){
        userService.saveUser(user);
        return;
    }



}
