package com.zsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.entity.RoleMenuEntity;
import com.zsn.utils.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 角色菜单关系
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
public interface RoleMenuService extends IService<RoleMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RoleMenuEntity> selectRoleMenuEntityByRoleIds(Long id);
}

