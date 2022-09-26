package com.zsn.filter;

import com.alibaba.fastjson.JSONObject;
import com.zsn.handler.HandlerLoginSuccess;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**AbstractAuthenticationProcessingFilter这是一个抽象类，定义了认证处理的过程。是一个模板类。
 这里每个filter实现类，都需要传入一个处理的url路径，
 当我们的请求match这个路径时，才会被该filter处理
 * @Author : zhou sen nan
 * @Date : 2022/8/16  9:42
 */
public class DefaultLoginFilter extends AbstractAuthenticationProcessingFilter {
    public DefaultLoginFilter(AuthenticationManager authenticationManager,HandlerLoginSuccess handlerLoginSuccess) {
        super(new AntPathRequestMatcher("/login", HttpMethod.POST.name()));
        setAuthenticationManager(authenticationManager);
        setAuthenticationSuccessHandler(handlerLoginSuccess);
        //setAuthenticationSuccessHandler(successHandler);

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException(
                    "Authentication method not supported: " + request.getMethod());
        }
        //获取表单中的用户名和密码
        String username = request.getParameter("username");
        System.out.println("获取到的姓名是："+username);
        String password  = request.getParameter("password");


        if (username == null) {
            username = "";
        }
        if (password == null) {
            password = "";
        }
        username = username.trim();
        //组装成username+password形式的token
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);
        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);
        //交给内部的AuthenticationManager去认证，并返回认证信息
        return this.getAuthenticationManager().authenticate(authRequest);
    }
    private void setDetails(HttpServletRequest request,
                            UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
