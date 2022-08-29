package com.zsn.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @Author : zhou sen nan
 * @Date : 2022/8/26  16:56
 */
@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
