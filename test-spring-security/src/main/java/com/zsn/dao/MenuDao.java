package com.zsn.dao;

import com.zsn.entity.MenuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单管理
 * 
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
@Mapper
public interface MenuDao extends BaseMapper<MenuEntity> {
	
}
