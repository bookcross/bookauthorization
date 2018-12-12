package com.trembear.bookauthorization.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * cookie处理工具类
 *
 * @author qlma
 * @date 2018/8/23 12:59
 */
public class CookieUtils {
    /**
     * 该方法没有用 为让sonar检查通过 注释掉
     *
     * @param response response
     * @param name     name
     * @param value    value
     * @param maxValue maxValue
     * @param domain   domain
     */
    //   public static void setCookie(HttpServletResponse response, String name, String value, String domain, int maxValue) {
//        if(StringUtils.isBlank(name)) {
//            return;
//        }
//        if(null == value) {
//            value = "";
//        }
//        Cookie cookie = new Cookie(name, value);
//        if(StringUtils.isNotBlank(domain)) {
//            cookie.setDomain(domain);
//        }
//        cookie.setPath("/");
//        if(maxValue != 0) {
//            cookie.setMaxAge(maxValue);
//        } else {
//            cookie.setMaxAge(-1);
//        }
//        response.addCookie(cookie);

    //   }

    /**
     * 获取cookie值
     *
     * @param request request
     * @param key     key
     * @return value
     */
    public static String getCookie(HttpServletRequest request, String key) {
        String cookievalue = null;
        Cookie[] cookies = request.getCookies();
        if(null == cookies) {
            return null;
        }
        for(Cookie cookie : cookies) {
            if(key.equals(cookie.getName())) {
                //取出cookie的值(表示已经在其他系统登陆过)
                cookievalue = cookie.getValue();
                break;
            }
        }
        return cookievalue;
    }

    public static boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("request-ajax") != null && "true".equals(request.getHeader("request-ajax").toString()));
    }
}
