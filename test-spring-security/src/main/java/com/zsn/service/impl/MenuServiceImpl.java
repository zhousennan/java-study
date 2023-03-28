package com.zsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zsn.dao.MenuDao;
import com.zsn.entity.MenuEntity;
import com.zsn.service.MenuService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MenuDao, MenuEntity> implements MenuService {
    @Autowired
    MenuDao menuDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<MenuEntity> page = this.page(
                new Query<MenuEntity>().getPage(params),
                new QueryWrapper<MenuEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<MenuEntity> selectMenuEntityByIds(List<Long> ids) {
        List<MenuEntity> menuEntities = menuDao.selectBatchIds(ids);
        return menuEntities;
    }

}