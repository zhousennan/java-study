package com.zsn.shiro.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zsn.shiro.entity.User;
import com.zsn.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:09
 */
public class CustomerRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;



    /**
     * 授权
     * @param principalCollection 授权
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }



    /**
     * 用户登录认证
     * @param authenticationToken 用户
     * @return AuthenticationInfo
     * @throws AuthenticationException  权限异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("====进入了认证方法====");

        //获得身份信息
        String principal = (String) authenticationToken.getPrincipal();
        //虚拟一个用户数据用来测试，
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, principal));
        //如果身份信息认证成功
        if (!ObjectUtils.isEmpty(user)){

            return new SimpleAuthenticationInfo(principal,user.getPassword(),this.getName());
        }

        return null;

    }

}
