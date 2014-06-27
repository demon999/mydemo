<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<%@ include file="../common.jsp" %>
<script type="text/javascript" src="<%= basePath %>res/js/tback.js"></script>
</head>
<body>
<form action="tback.action" method="POST" id="mainForm">
<div id="contral" style="width:600px;"> 
<input type="text" name="username"  value=""> 
<input type="text" name="password" value=""> 
<input type="button" id="addBtn" value="Add">
</div>
<div id="table" style="width:600px;"></div>
</form>
</body>
</html>