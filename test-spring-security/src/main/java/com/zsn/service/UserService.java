package com.zsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zsn.utils.PageUtils;
import com.zsn.utils.Query;
import com.zsn.entity.UserEntity;

import java.util.Map;

/**
 * 系统用户
 *
 * @author zsn
 * @email 1765509297@qq.com
 * @date 2022-08-05 17:50:26
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

    UserEntity getUserByUserName(String userName);
}

