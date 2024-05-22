package com.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.jdbc.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zsn
 * @Date: 2024/5/20 16:28
 * @Description: description of this class
 * @Version: 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User getUserById(Long id);

    void save(@Param("user") User user);
}
