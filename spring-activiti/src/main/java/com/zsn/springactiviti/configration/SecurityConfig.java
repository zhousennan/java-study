package com.zsn.springactiviti.configration;

import com.zsn.springactiviti.entity.Permission;
import com.zsn.springactiviti.reposity.PermissionMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@Slf4j
public class SecurityConfig {

    @Autowired
    private PermissionMapper permissionMapper;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry
                authorizeRequests = http.csrf().disable().authorizeRequests();
//        方式二：配置来源于数据库
//         1.查询到所有的权限
        List<Permission> allPermission = permissionMapper.findAllPermission();
//         2.分别添加权限规则
        allPermission.forEach((p -> {
            authorizeRequests.antMatchers(p.getUrl()).hasAnyAuthority(p.getName()) ;
        }));

        authorizeRequests.antMatchers("/**").fullyAuthenticated()
                .anyRequest().authenticated().and().formLogin();
        return http.build();
    }

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring().antMatchers("/css/**");
            web.ignoring().antMatchers("/js/**");
            web.ignoring().antMatchers("/img/**");
            web.ignoring().antMatchers("/plugins/**");
            web.ignoring().antMatchers("/login.html");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
