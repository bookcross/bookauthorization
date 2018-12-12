package com.trembear.bookauthorization.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * @author Junwei.Xiong
 * @description
 * @since 2018-12-05 10:50
 */
@RestController
public class TestController {
    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal.getName());
        return principal;
    }
    @RequestMapping("/public")
    public void getPublic(HttpServletResponse response,@RequestBody String name){
        try {
            response.getWriter().write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        return name+"public method";
    }
    @RequestMapping("/private")
    public String getPrivate(){
        return "private method";
    }
}
