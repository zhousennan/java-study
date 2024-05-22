package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;

import com.zsn.dao.RoleMenuDao;
import com.zsn.entity.RoleMenuEntity;
import com.zsn.service.RoleMenuService;


@Service("roleMenuService")
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuDao, RoleMenuEntity> implements RoleMenuService {


    @Autowired
    RoleMenuDao roleMenuDao;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RoleMenuEntity> page = this.page(
                new Query<RoleMenuEntity>().getPage(params),
                new QueryWrapper<RoleMenuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<RoleMenuEntity> selectRoleMenuEntityByRoleIds(Long id) {
        List<RoleMenuEntity> roleMenuEntities = roleMenuDao.selectList(new LambdaQueryWrapper<RoleMenuEntity>().eq(
                RoleMenuEntity::getRoleId, id
        ));
        return roleMenuEntities;
    }

}