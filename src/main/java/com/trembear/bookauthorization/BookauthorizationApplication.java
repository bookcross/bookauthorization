package com.trembear.bookauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@SpringBootApplication
@RestController
@EnableResourceServer
public class BookauthorizationApplication {
    @RequestMapping("/user/me")
    public Principal user(Principal principal) {
        System.out.println(principal.getName());
        return principal;
    }
    @RequestMapping("/public")
    public String getPublic(){
        return "public method";
    }
    @RequestMapping("/private")
    public String getPrivate(){
        return "private method";
    }
    public static void main(String[] args) {
        SpringApplication.run(BookauthorizationApplication.class, args);
    }
}
