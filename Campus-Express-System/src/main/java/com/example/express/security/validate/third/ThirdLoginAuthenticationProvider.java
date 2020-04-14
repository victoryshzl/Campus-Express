package com.example.express.security.validate.third;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 三方登陆鉴权 Provider，要求实现 AuthenticationProvider 接口
 */
@Slf4j
public class ThirdLoginAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    /**
     * 三方登陆无需鉴权，参数即是用户ID
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ThirdLoginAuthenticationToken authenticationToken = (ThirdLoginAuthenticationToken) authentication;

        String userId = (String) authenticationToken.getPrincipal();

        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

        // 此时鉴权成功后，应当重新 new 一个拥有鉴权的 authenticationResult 返回
        ThirdLoginAuthenticationToken authenticationResult = new ThirdLoginAuthenticationToken(userDetails, userDetails.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // 判断 handler 是不是 SmsCodeAuthenticationToken 的子类或子接口
        return ThirdLoginAuthenticationToken.class.isAssignableFrom(authentication);
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
