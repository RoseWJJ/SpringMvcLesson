<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 增加 -->
	<form action="${pageContext.request.contextPath}/user/"  method="post">
		<input type="text" name = "id">
		<input type="text" name = "name">
		<input type="text" name = "sex">
		<input type="submit" value="增加">  
	
	</form>
	<!-- 删除 -->
	<form action="${pageContext.request.contextPath}/user/1"  method="post">
	<input type='hidden' name="_method" value="delete"/>
		<input type="text" name = "id">
		<input type="submit" value="删除">  
	
	</form>
	<!-- 修改 -->
	<form action="${pageContext.request.contextPath}/user/2"  method="post">
	<input type='hidden' name="_method" value="put"/>
		<input type="text" name = "id">
		<input type="text" name = "name">
		<input type="text" name = "sex">
	
		<input type="submit" value="修改">  
	
	</form>
	<!-- 查看 --><!--
	<form action="${pageContext.request.contextPath}/user/"  method="get">
		<input type="text" name = "name">
		<input type="submit" value="提交">  
	
	</form>
	--><a href="${pageContext.request.contextPath}/user">查询</a>
</body>
</html>