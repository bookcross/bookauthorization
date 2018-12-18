package com.trembear.bookauthorization.controller;

import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.vo.RestFulVO;
import com.trembear.bookauthorizationapi.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author Junwei.Xiong
 * since 2018-12-13 13:45
 */
@RestController
@RequestMapping("/user")
public class BCUserController {
    @RequestMapping("/register")
    public RestFulVO register(UserDto userDto){
        BCUser bcUser=new BCUser();
        BeanUtils.copyProperties(userDto,bcUser);
        return new RestFulVO();
    }
}
