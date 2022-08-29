package com.zsn.config;

import com.zsn.filter.DefaultLoginFilter;
import com.zsn.handler.HandlerLoginSuccess;
import com.zsn.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/15  11:38
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
// 关闭csrf 前后端未分离，并且使用thymeleaf模板，可以注释此配置
        //http.csrf().disable();

        // 配置登录页面
        http.formLogin().loginPage("/login").permitAll();

        // 配置登录成功后的默认页面
        // http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().successHandler(new HandlerLoginSuccess());

        // 授权配置
        http.authorizeRequests().
                antMatchers("/js/**\",\"/css/**\",\"/images/**").permitAll().
                antMatchers("/ad/**").permitAll()
                .anyRequest().fullyAuthenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DefaultLoginFilter defaultLoginFilter(){
        DefaultLoginFilter defaultLoginFilter =new DefaultLoginFilter("/login");
        return defaultLoginFilter;
    }
}
