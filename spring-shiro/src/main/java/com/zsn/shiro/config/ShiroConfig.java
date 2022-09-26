package com.zsn.shiro.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/29  15:11
 */
@Configuration
public class ShiroConfig {

    //1.创建ShiroFilter,拦截所有的请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();


        bean.setSecurityManager(securityManager);

        /*添加过滤器
         * anon:无需认证就可以访问
         * authc：必须认证了才能访问
         * user：必须拥有 记住我 功能才能使用
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         * */
        //创建一个map，map中决定哪些资源是受限的，哪些资源是公共的
        HashMap<String, String> map = new HashMap<String, String>();

        //访问index.jsp需要认证
        //map.put("/index","authc");
       // map.put("/goindex","authc");
        //将拦截的请求放入过滤器
        bean.setFilterChainDefinitionMap(map);

        //默认认证的界面路径，当登录失败时自动跳转到该页面进行认证
        bean.setLoginUrl("/login");

        return bean;


    }

    //2.创建SecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(realm);

        return securityManager;
    }
    //3.创建自定义的Realm
    @Bean(name = "realm")
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        return customerRealm;
    }
}
