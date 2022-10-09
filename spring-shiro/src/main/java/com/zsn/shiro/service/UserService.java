package com.zsn.shiro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.shiro.entity.User;

/**
 * @Author : zhou sen nan
 * @Date : 2022/9/26  14:14
 */
public interface UserService  extends IService<User> {
    /**
     * 用户注册
     * @param user 用户信息实体
     */
    void register(User user);
}
