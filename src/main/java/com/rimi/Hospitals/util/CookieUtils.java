package com.rimi.Hospitals.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类
 *
 * @author shangzf
 * @date 2019/9/9 16:42
 */
public class CookieUtils {

    /**
     * 获取cookie值
     *
     * @param name    cookie的名称
     * @param request 请求
     * @return cookie的值
     */
    public static String getCookie(String name, HttpServletRequest request) {
        // 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                // 获取cookie的name
                String name1 = cookie.getName();
                if (name1.equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /**
     * 设置cookie
     *
     * @param name     cookie的名称
     * @param value    cookie的值
     * @param response 响应
     */
    public static void setCookie(String name, String value, HttpServletResponse response) {
        setCookie(name, value, -1, response);
    }

    /**
     * 设置cookie
     *
     * @param name     cookie的名称
     * @param value    cookie的值
     * @param maxAge   最大有效时间(单位:秒)
     * @param response 响应
     */
    public static void setCookie(String name, String value, int maxAge, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 设置cookie
     *
     * @param name     cookie的名称
     * @param value    cookie的值
     * @param maxAge   最大有效时间(单位:秒)
     * @param path     cookie的作用域
     * @param response 响应
     */
    public static void setCookie(String name, String value, int maxAge, String path, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
}
