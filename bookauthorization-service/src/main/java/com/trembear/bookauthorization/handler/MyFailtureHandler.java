package com.trembear.bookauthorization.handler;

import com.alibaba.fastjson.JSON;
import com.trembear.bookauthorization.base.BaseRest;
import com.trembear.bookauthorization.enums.SystemRest;
import com.trembear.bookauthorization.vo.RestFulVO;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Junwei.Xiong
 * @description
 * @since 2018-12-05 11:11
 */
@Component("myFailtureHandler")
public class MyFailtureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        RestFulVO restFulVO=new RestFulVO(SystemRest.USER_PASSWORD_FAULT);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(restFulVO));
    }
}
