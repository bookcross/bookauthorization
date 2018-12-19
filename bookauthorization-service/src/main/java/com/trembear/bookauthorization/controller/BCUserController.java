package com.trembear.bookauthorization.controller;

import com.alibaba.fastjson.JSON;
import com.trembear.authorizationapi.dto.UserDto;
import com.trembear.bookauthorization.base.BaseRest;
import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.service.BackendUserService;
import com.trembear.bookauthorization.vo.RestFulVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * description
 *
 * @author Junwei.Xiong
 * since 2018-12-13 13:45
 */
@RestController
@RequestMapping("/user")
public class BCUserController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    BackendUserService backendUserService;
    @RequestMapping("/register")
    public RestFulVO register(UserDto userDto){
        BCUser bcUser=new BCUser();
        BeanUtils.copyProperties(userDto,bcUser);
        return new RestFulVO();
    }
    @RequestMapping("/getUser")
    public RestFulVO getUser(){
        String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("Authorization").split("Bearer ")[1];
        String userSerilize= (String) redisTemplate.opsForValue().get(token);
        UserDto userDto= JSON.parseObject(userSerilize,UserDto.class);
        return new BaseRest().restSuccess(userDto);
    }
    @RequestMapping("/updateUser")
    public RestFulVO updateUser(@RequestBody UserDto userDto){
        if (backendUserService.judgeSameUsername(userDto.getUsername())){
            int i=backendUserService.updateUser(userDto);
            return new BaseRest().restSuccess("Success");
        }else
            return new BaseRest().restSimpleFault("用户名重复");
    }
}
