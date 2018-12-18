package com.trembear.bookauthorization.service;


import com.trembear.bookauthorization.dao.BCUserMapper;
import com.trembear.bookauthorization.entity.BCUser;
import com.trembear.bookauthorization.entity.BCUserExample;
import com.trembear.bookauthorization.vo.RestFulVO;
import com.trembear.bookauthorizationapi.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author 创建者 wei.wang
 * @author 修改者 wei.wang
 * @version 2018/8/1
 * @Description
 * @since 2018/8/1
 */
@Service("backendUserService")
public class BackendUserService implements UserDetailsService {
    @Autowired
    BCUserMapper bcUserMapper;
    public RestFulVO register(UserDto userDto){
        BCUser bcUser=new BCUser();
        BeanUtils.copyProperties(userDto,bcUser);
        bcUserMapper.insert(bcUser);
        return new RestFulVO();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        BCUser backendUser = new BCUser();
        BCUserExample bcUserExample=new BCUserExample();
        BCUserExample.Criteria criteria=bcUserExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        try {
            backendUser=bcUserMapper.selectByExample(bcUserExample).get(0);
        }catch(Exception e){
//            return null;
        }
        return backendUser;
    }
}
