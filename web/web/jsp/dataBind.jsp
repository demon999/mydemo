<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<%@ include file="../common.jsp" %>
<script type="text/javascript">
$(function(){
	$("#submitBtn").on("click",function(){
		$("#mainForm").submit();
	});
});
</script>
</head>
<body>
<form action="dataBind.action" method="POST" id="mainForm">

<input type="text" name="name"  value=""> 
<input type="text" name="password" value=""> 

<input type="button" id="submitBtn" value="Test">

</form>
</body>
</html>