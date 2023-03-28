package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.dao.RoleDao;
import com.zsn.entity.RoleEntity;
import com.zsn.service.RoleService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {


    @Autowired
    RoleDao roleDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoleEntity> page = this.page(
                new Query<RoleEntity>().getPage(params),
                new QueryWrapper<RoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public RoleEntity selectRoleByRoleId(Long id) {
        RoleEntity roleEntity = roleDao.selectById(id);
        return roleEntity;
    }

}