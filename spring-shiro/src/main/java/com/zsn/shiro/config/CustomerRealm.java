package com.zsn.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:09
 */
public class CustomerRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("====进入了认证方法====");

        //获得身份信息
        String principal = (String) authenticationToken.getPrincipal();
        //虚拟一个用户数据用来测试，
        if ("zsn".equals(principal)){//如果身份信息认证成功
            return new SimpleAuthenticationInfo(principal,"123",this.getName());
        }

        return null;

    }
}
