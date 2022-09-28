package com.zsn.shiro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.shiro.entity.User;
import com.zsn.shiro.mapper.UserMapper;
import com.zsn.shiro.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author : zhou sen nan
 * @Date : 2022/9/26  14:14
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
