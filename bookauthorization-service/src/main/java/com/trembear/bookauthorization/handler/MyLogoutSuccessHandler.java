package com.trembear.bookauthorization.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Junwei.Xiong
 * @description
 * @since 2018-12-04 10:42
 */
@Component("myLogoutSuccessHandler")
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println(authentication);
        String token=httpServletRequest.getHeader("Authorization").split("Bearer ")[1];
        consumerTokenServices.revokeToken(token);

    }
}
