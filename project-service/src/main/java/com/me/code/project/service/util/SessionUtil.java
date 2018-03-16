package com.me.code.project.service.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * session处理工具类
 */
public class SessionUtil {


    private SessionUtil() {

    }

    /**
     * 从cookie中取出sessionid
     */
    public static String getSessionIdFromCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        String sessionId = null;
        for (Cookie cookie : cookies) {
            if ("sessionId".equals(cookie.getName())) {
                sessionId = cookie.getValue();
            }
        }
        return sessionId;
    }

}
