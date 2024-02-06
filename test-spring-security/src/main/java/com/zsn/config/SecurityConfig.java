package com.zsn.config;

import com.zsn.filter.DefaultLoginFilter;
import com.zsn.handler.HandlerLoginSuccess;
import com.zsn.provider.NoRedirectStrategy;
import com.zsn.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

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
        http.csrf().disable();

        // 配置登录页面
        //http.formLogin().loginPage("/login").permitAll();



        // 授权配置
        http.authorizeRequests().
                antMatchers("/js/**\",\"/css/**\",\"/images/**").permitAll().
                antMatchers("/ad/**").permitAll().
                antMatchers("/login111").permitAll()
                .anyRequest().fullyAuthenticated()
        .and().userDetailsService(myUserDetailsService);

        //单一登录过滤器
        http.addFilterBefore(new DefaultLoginFilter(authenticationManager(),handlerLoginSuccess()), AbstractPreAuthenticatedProcessingFilter.class);

        // 配置登录成功后的默认页面
        // http.formLogin().defaultSuccessUrl("/home");
        http.formLogin().successHandler(handlerLoginSuccess());
    }

    //自定义登录认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //1使用重写的security进行登录认证
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
        //TODO 使用自定义登录身份认证组件

        //auth.authenticationProvider(defaultAuthenticationProvider)
        //        .authenticationProvider(ssoAuthenticationProvider);

    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public DefaultLoginFilter defaultLoginFilter(){
//        DefaultLoginFilter defaultLoginFilter =new DefaultLoginFilter("/login");
//        return defaultLoginFilter;
//    }

    //定义认证
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

   /* @Bean
    public DefaultLoginFilter defaultLoginFilter() throws Exception {
        DefaultLoginFilter defaultLoginFilter = new DefaultLoginFilter();
        defaultLoginFilter.setAuthenticationManager(authenticationManager());
        defaultLoginFilter.setAuthenticationSuccessHandler(handlerLoginSuccess());
        return defaultLoginFilter;
    }*/

    @Bean
    public HandlerLoginSuccess handlerLoginSuccess(){
        return new HandlerLoginSuccess();
    }




}
