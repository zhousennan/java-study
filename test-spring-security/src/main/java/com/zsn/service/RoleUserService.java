package com.zsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import com.zsn.entity.RoleUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色用户关系
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
public interface RoleUserService extends IService<RoleUserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<RoleUserEntity> getRoleUserEntitiesByUserId(Long userId);
}

