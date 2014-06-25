package com.snow.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 定义Session拦截器
 * @author xue_liming
 * @date 2013-03-02
 */
public class SessionInterceptor extends HandlerInterceptorAdapter  {
	/** 日志 */
	private Logger log = LoggerFactory.getLogger(SessionInterceptor.class);
	/** 不需要拦截session的action */
	private static List<String> actionList = new ArrayList<String>();
	
	static {
		actionList.add("index.action");
		actionList.add("login.action");
		actionList.add("userLogin.action");
		actionList.add("orderLogin.action");
		actionList.add("checkLogin.action");
		actionList.add("inOperating.action");
		actionList.add("loginValidate.action");
		actionList.add("loginExit.action");
		actionList.add("pswd.action");
		actionList.add("resetPassword.action");
		actionList.add("store.action");
		actionList.add("delAddrAction.action");
	}

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {
		String actionName = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
		log.info("execute action : {} start------>",actionName);
//		if(actionList.contains(actionName)) {
//			return true;
//		}
//		//判断session里是否有用户信息  
//        if (request.getSession() == null || request.getSession().getAttribute(CommonDef.CUSTOMER) == null) {  
//        	//如果是ajax请求响应头会有，x-requested-with
//            if (request.getHeader("x-requested-with") != null  && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))  {  
//            	//在响应头设置session状态
//            	response.setHeader("sessionstatus", "timeout");  
//            }  
//			PrintWriter out = response.getWriter();  
//			StringBuilder builder = new StringBuilder();
//			//String basePath = request.getContextPath();
//			//builder.append("<script type=\"text/javascript\" src=\""+basePath+"/res/js/yum.base.js\"></script>");
//			builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");  
//			//builder.append("base.yumAlert(\"页面过期，请重新登录!\");");  
//            //builder.append("base.setAction(\"orderLogin.action\");");  
//			builder.append("alert(\"页面过期，请重新登录\");");
//			builder.append("window.location.href=\"login.jsp\";");
//            builder.append("</script>");
//            out.print(builder.toString());  
//            out.close();  
//            return false;
//        }  
        return true;  
	}
	
}
