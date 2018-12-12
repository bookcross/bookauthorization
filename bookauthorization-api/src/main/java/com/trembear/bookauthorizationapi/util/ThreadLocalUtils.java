package com.trembear.bookauthorizationapi.util;

import com.trembear.bookauthorizationapi.dto.UserDto;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * description
 *
 * @author Junwei.Xiong
 * since 2018-12-12 11:08
 */
public class ThreadLocalUtils {
    private static ThreadLocal<UserDto> threadLocal = new ThreadLocal();

    public static void set(UserDto value) {
        threadLocal.set(value);
    }
    public static UserDto get() {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserDto s = (UserDto) req.getAttribute("currentuser");
        return s;
    }
    public static void remove(){
        threadLocal.remove();
    }
}
