package com.trembear.bookauthorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
    private BackendUserService backendUserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/login", "/oauth/**","/public/**")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .successHandler(adminAuthenticationSuccessHandler)
//                .defaultSuccessUrl("/public/1")
                .permitAll()
                .and()
                .csrf().disable(); //注销行为任意访问
    }

}
