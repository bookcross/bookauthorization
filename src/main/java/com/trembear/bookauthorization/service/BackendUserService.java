package com.trembear.bookauthorization.service;


import com.trembear.bookauthorization.entity.BackendUser;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BackendUser backendUser = new BackendUser();
        if(username.equals("tom")){
            backendUser.setUsername(username);
            backendUser.setPassword("123");
            return backendUser;
        }
        if(username.equals("john")){
            backendUser.setUsername(username);
            backendUser.setPassword("1234");
            return backendUser;
        }
        return null ;
    }
}
