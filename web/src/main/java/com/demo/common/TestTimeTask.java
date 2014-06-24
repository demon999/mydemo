package com.demo.common;

import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class TestTimeTask extends TimerTask implements ServletContextAware {

	/*通过实现ServletContextAware可获得servletContext*/
	private ServletContext context;  
	
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		System.out.println("TestTimeTask----->"+new Date().toString());
	}

}
