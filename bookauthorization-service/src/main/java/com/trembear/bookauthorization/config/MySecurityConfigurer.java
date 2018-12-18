package com.trembear.bookauthorization.config;

import com.trembear.bookauthorization.handler.MyFailtureHandler;
import com.trembear.bookauthorization.handler.MyLogoutSuccessHandler;
import com.trembear.bookauthorization.service.BackendUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Junwei.Xiong
 * @description WebSecurityConfigurerAdapter
 * @since 2018-11-19 11:16
 */
@Configuration
@Order(1)
@EnableWebSecurity
public class MySecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationSuccessHandler adminAuthenticationSuccessHandler;
    @Autowired
    private MyLogoutSuccessHandler myLogoutSuccessHandler;
    @Autowired
    private MyFailtureHandler myFailtureHandler;
    @Autowired
    private BackendUserService backendUserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login", "/oauth/**","/public","/logout")
                .and()
                .authorizeRequests()
                .antMatchers("/public","/login","/authentication/form").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(adminAuthenticationSuccessHandler)
                .failureHandler(myFailtureHandler)
//                .defaultSuccessUrl("/public/1")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessHandler(myLogoutSuccessHandler)
                .permitAll()
                .and()
                .csrf().disable(); //注销行为任意访问
    }

}
