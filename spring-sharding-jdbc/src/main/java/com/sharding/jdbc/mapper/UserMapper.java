package com.sharding.jdbc.mapper;

import com.sharding.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: zsn
 * @Date: 2024/5/20 16:28
 * @Description: description of this class
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    User getUserById(Long id);
}
