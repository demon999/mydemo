package com.snow.test;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线用户个数
 * @author xue_liming
 *
 */
public class SessionListenerImpl implements HttpSessionListener {

	private int count = 0;
	
	private int max = 1000;
	
	public void sessionCreated(HttpSessionEvent event) {
		count++;
		System.out.println("SessionListenerImpl ---> sessionCreated");
		System.out.println("count="+count);
		event.getSession().setAttribute("onlineUserBindingListener", new SessionBindingListenerImpl("username1"));
		if(count >= max) {
			event.getSession();
		}
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		count--;
		System.out.println("SessionListenerImpl ---> sessionDestroyed");
		System.out.println("count="+count);
	}

}
