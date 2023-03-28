package com.zsn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsn.entity.RoleUserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色用户关系
 * 
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
@Mapper
public interface RoleUserDao extends BaseMapper<RoleUserEntity> {
	
}
