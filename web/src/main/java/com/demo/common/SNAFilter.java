package com.demo.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SNAFilter extends HandlerInterceptorAdapter {
	
	private String loginAction = "loginValidate.action";
	
	private String key = "PHHS_IOS_SID";
	
	private String filterUrls = "index.action,orderLogin.action,seo.action,createSeoHtml.action,inOperating.action,getCookie.action";
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		
		String actionName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		if(filterUrls.indexOf(actionName) > -1) {
			return true;
		} else if(loginAction.equals(actionName)) {
			this.saveSNACookie(request, response, key);
			// clean memcached
		} else {
			String oldSid = this.getSNACookie(request, response, key);
			if(oldSid != null && oldSid.trim() != "" && !oldSid.equals(request.getSession().getId())) {
				// 将memcached中数据同步到session
				// MSessionUtil.synchSession(client, request.getSession(),oldSid);
				// 将新的session id存放到cookie
				this.saveSNACookie(request, response, key);
			}
		}
		return true;
	}
	
	/**
     * 获取cookie对应的值
     * @param request
     * @param key key值
     * @return
     */
	public String getSNACookie(HttpServletRequest request,HttpServletResponse response,String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return "";
		}
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			if(cookie.getName().equals(key)) {
				return cookie.getValue();
			}
		}
		return "";
	}
	
	/**
     * 获取cookie对应的值,然后清除
     * @param request
     * @param key key值
     * @return
     */
	public String saveSNACookie(HttpServletRequest request,HttpServletResponse response,String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length == 0) {
			return "";
		}
		String sid = request.getSession().getId();
	    Cookie curCookie = new Cookie(key,sid);
		response.addCookie(curCookie);
		return sid;
	}
}
