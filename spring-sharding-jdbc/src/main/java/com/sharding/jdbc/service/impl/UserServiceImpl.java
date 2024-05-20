package com.sharding.jdbc.service.impl;

import com.sharding.jdbc.mapper.UserMapper;
import com.sharding.jdbc.pojo.User;
import com.sharding.jdbc.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zsn
 * @Date: 2024/5/20 16:29
 * @Description: description of this class
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
      User user =  userMapper.getUserById(id);
        return user;
    }
}
