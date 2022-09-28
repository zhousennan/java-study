package com.zsn.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:47
 */
@Data
@TableName("sys_user")
public class User {
    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 头像
     */
    private String headUrl;
    /**
     * 性别   0：男   1：女    2：保密
     */
    private Integer gender;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 超级管理员   0：否   1：是
     */
    private Integer superAdmin;
    /**
     * 状态  0：停用   1：正常
     */
    private Integer status;
    /**
     * 创建者
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新者
     */
    private Long updater;
    /**
     * 更新时间
     */
    private Date updateDate;
}
