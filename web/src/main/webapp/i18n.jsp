<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>I18n Demo</title>
<%@ include file="common.jsp" %>
<script type="text/javascript" src="res/lib/jquery-1.10.1.js"></script> 
<script type="text/javascript" src="res/lib/jquery.i18n.properties-1.0.9.js"></script> 
<script type="text/javascript" src="res/js/jquery.custom.js"></script> 
<script type="text/javascript" src="res/js/i18n.js"></script> 
<script type="text/javascript">
$(function(){
	/*
	 jQuery.i18n.properties({ 
	    name:'message',// 资源文件名称
	    path:'res/i18n/',// 资源文件所在目录路径
	    mode:'both',// 模式：变量或 Map 
	    language:'en-US',// 对应的语言
	    cache:false, 
	    encoding: 'UTF-8', 
	    callback: function() {// 回调方法
	    	$("#label_username").text($.i18n.prop('username'));
	    	$("#label_password").text(password);
	    	$("#button_login").val(login);
	    	alert(complex('John')); 
	    } 
	 }); 
	*/
	
	/*
	alert(navigator.language);
	alert($.i18n.browserLang());
	*/
	
	i18n.load("message");
	// $.i18n.load("message");
	//
	$("#label_username").text($.i18n.prop('username'));
	$("#label_password").text(password);
	$("#button_login").val(login);
	
	$("#button_login").on("click",function(){
		alert(complex('John')); 
	});
});
</script>
</head>
<body>
	<div id="content"> 
	 <div> 
	 <label id="label_username"></label> 
	 <input type="text" id="username"></input> 
	 </div> 
	 <div> 
	 <label id="label_password"></label> 
	 <input type="password" id="password"></input> 
	 </div> 
	 <input type="button" id="button_login"/> 
	 </div> 
</body>
</html>

 