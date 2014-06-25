package com.snow.test;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 单个用户在线与下线状态
 * @author xue_liming
 *
 */
public class SessionBindingListenerImpl implements HttpSessionBindingListener {
	
	private String username = "";
	
	public SessionBindingListenerImpl(String username) {
		this.username = username;
	}

	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("SessionBindingListenerImpl ---> valueBound");
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();
	    // 把用户名放入在线列表
	    List onlineUserList = (List) context.getAttribute("onlineUserList");
	    // 第一次使用前，需要初始化
	    if (onlineUserList == null) {
	        onlineUserList = new ArrayList();
	        context.setAttribute("onlineUserList", onlineUserList);
	    }
	    ((List)context.getAttribute("onlineUserList")).add(this.username);
	    
//	    event.getName()
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("SessionBindingListenerImpl ---> valueUnbound");
		HttpSession session = event.getSession();
	    ServletContext application = session.getServletContext();

	    // 从在线列表中删除用户名
	    List onlineUserList = (List) application.getAttribute("onlineUserList");
	    onlineUserList.remove(this.username);
	    System.out.println(this.username + "退出。");
	}

}
