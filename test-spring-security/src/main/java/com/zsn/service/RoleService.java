package com.zsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import com.zsn.entity.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色管理
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
public interface RoleService extends IService<RoleEntity> {

    PageUtils queryPage(Map<String, Object> params);

    RoleEntity selectRoleByRoleId(Long id);
}

