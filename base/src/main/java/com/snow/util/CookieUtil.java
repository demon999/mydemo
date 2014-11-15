package com.snow.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Richard Xue on 14-7-17.
 */
public final class CookieUtil {
    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);
    private final static String cookieKey = "defaultCookieKey";
    private final static String cookieValue = "defaultCookieValue";
    public final static int cookieMaxAge = 60 * 60 * 24 * 7 * 2;

    public static void saveCookie(HttpServletResponse response) {
        saveCookie(response, cookieKey, cookieValue, cookieMaxAge);
    }

    public static void saveCookie(HttpServletResponse response,String key,String value,int maxAge) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void clearCookie(HttpServletResponse response) {
        clearCookie(response,cookieKey);
    }

    public static void clearCookie(HttpServletResponse response,String key) {
        Cookie cookie = new Cookie(key, null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request) {
        return getCookie(request,cookieKey);
    }

    public static String getCookie(HttpServletRequest request, String key) {
        Cookie cookies[] = request.getCookies();
        String cookieValue = null;
        if (cookies != null) {
            return cookieValue;
        }
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (key.equals(cookie.getName())) {
                cookieValue = cookie.getValue();
                break;
            }
        }
        return cookieValue;
    }
}
