package com.trembear.bookauthorization.handler;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trembear.bookauthorization.base.BaseRest;
import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.vo.RestFulVO;
import com.trembear.bookauthorizationapi.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Junwei.Xiong
 * @description
 * @since 2018-11-29 14:29
 */
@Component("adminAuthenticationSuccessHandler")
public class AdminAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    Logger successHandlerlogger = LoggerFactory.getLogger(AdminAuthenticationSuccessHandler.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        String clientId = "client";
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
        TokenRequest tokenRequest = new TokenRequest(null, clientId, clientDetails.getScope(), "");
        OAuth2Request oAuth2Request = tokenRequest.createOAuth2Request(clientDetails);
        OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
        OAuth2AccessToken oAuth2AccessToken = authorizationServerTokenServices.createAccessToken(oAuth2Authentication);
        BCUser user= (BCUser)authentication.getPrincipal();
        UserDto userDto=new UserDto();
        BeanUtils.copyProperties(user,userDto);
        successHandlerlogger.info("{}登录成功",userDto.getUsername());
//        ThreadLocalUtils.set(userDto);
//        ThreadLocalUtils.get();
        String tokenValue = oAuth2AccessToken.getValue();
        redisTemplate.opsForValue().set(tokenValue,JSON.toJSONString(userDto));
        response.setContentType("application/json;charset=UTF-8");
        RestFulVO restFulVO=new BaseRest().restSuccess(tokenValue);
        response.getWriter().write(JSON.toJSONString(restFulVO));
    }
}
