package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.dao.RoleUserDao;
import com.zsn.entity.RoleUserEntity;
import com.zsn.service.RoleUserService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("roleUserService")
public class RoleUserServiceImpl extends ServiceImpl<RoleUserDao, RoleUserEntity> implements RoleUserService {

    @Autowired
    RoleUserDao roleUserDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoleUserEntity> page = this.page(
                new Query<RoleUserEntity>().getPage(params),
                new QueryWrapper<RoleUserEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<RoleUserEntity> getRoleUserEntitiesByUserId(Long userId) {
        List<RoleUserEntity> roleUserEntities = roleUserDao.selectList(new LambdaQueryWrapper<RoleUserEntity>().eq(
                RoleUserEntity::getUserId, userId
        ));

        return roleUserEntities;
    }

}