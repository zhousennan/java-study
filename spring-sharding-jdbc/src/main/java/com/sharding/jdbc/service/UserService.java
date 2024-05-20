package com.sharding.jdbc.service;

import com.sharding.jdbc.pojo.User;

/**
 * @Author: zsn
 * @Date: 2024/5/20 16:28
 * @Description: description of this class
 * @Version: 1.0
 */
public interface UserService {

    User getUserById(Long id);
}
