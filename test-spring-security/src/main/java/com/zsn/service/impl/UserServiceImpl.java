package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;

import com.zsn.dao.UserDao;
import com.zsn.entity.UserEntity;
import com.zsn.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserEntity> page = this.page(
                new Query<UserEntity>().getPage(params),
                new QueryWrapper<UserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        UserEntity userEntity = userDao.selectOne(new LambdaQueryWrapper<UserEntity>().eq(UserEntity::getUsername, userName));
        return userEntity;
    }

}