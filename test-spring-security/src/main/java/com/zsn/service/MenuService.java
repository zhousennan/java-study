package com.zsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.entity.MenuEntity;
import com.zsn.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
public interface MenuService extends IService<MenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<MenuEntity> selectMenuEntityByIds(List<Long> ids);
}

