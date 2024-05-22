package com.zsn.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.shiro.entity.User;
import com.zsn.shiro.mapper.UserMapper;
import com.zsn.shiro.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Author : zhou sen nan
 * @Date : 2022/9/26  14:14
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) throws RuntimeException {
        if (ObjectUtils.isEmpty(user)){
            throw new RuntimeException("用户信息为null");
        }
        final User selectOneUser = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()));

        if (ObjectUtils.isEmpty(selectOneUser)){
            final String password = user.getPassword();
            user.setPassword(passwordEncryption(password));
            userMapper.insert(user);
        }else {
         throw   new RuntimeException("用户民已存在");
        }

    }

    private String passwordEncryption(String password){

        final Md5Hash md5Hash = new Md5Hash(password);
        return md5Hash.toHex();
    }
}
