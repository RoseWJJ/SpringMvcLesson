<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="xx"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'demo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
			<script type="text/javascript">
function checkInfor() {
	/*var name = document.getElementsByName("userName")[0].value;
	if (name == null || name == "") {
		alert("用户名不能为空");
		return;
	}
	var password = document.getElementsByName("password")[0].value;
	var rePassword = document.getElementsByName("rePassword")[0].value;
	if (password == null || password == "" ) {
		alert("密码不能为空");
		if(rePassword==password){
			alert("密码不一致");
			return;
		}
		return;
	}*/
	document.forms[0].submit();
}
</script>
	</head>
	<body>
		<form action="<%=path %>/demo"  method="post">
			<table border="1" align="center">
				<tr>
					<td>
						用户名：
						<td/>
							<td>
								<input type="text" name="userName" /><font color=red><xx:errors path="userInfor.userName"></xx:errors></font>
								<td/>
				</tr>
				<tr>
					<td>
						密码：
						<td />
							<td>
								<input type="password" name="password" /><font color=red><xx:errors path="userInfor.password"></xx:errors></font>
								<td />
								
				</tr>
				<tr>
					<td>
						确认密码：
						<td />
							<td>
								<input type="password" name="rePassword" /><font color=red><xx:errors path="userInfor.rePassword"></xx:errors></font>
								<td />
				</tr>
				<tr>
					<td>
						邮箱：
						<td />
							<td>
								<input type="text" name="email" /><font color=red><xx:errors path="userInfor.email"></xx:errors></font>
								<td />
							
				</tr>
				<tr>
					<td>
						个人网站：
						<td />
							<td>
								<input type="text" name="url" /><font color=red><xx:errors path="userInfor.url"></xx:errors></font>
								<td />
				</tr>
				<tr>
					<td>
						手机号码：
						<td />
							<td>
								<input type="text" name="phone" /><font color=red><xx:errors path="userInfor.phone"></xx:errors></font>
								<td />
				</tr>
				<tr>
					<td>
						年龄 ：
						<td />
							<td>
								<input type="text" name="age" /><font color=red><xx:errors path="userInfor.age"></xx:errors></font>
								<td />
				</tr>
				<tr>
					<td>
						注册时间：
						<td />
							<td>
								<input type="text" name="regTime" /><font color=red><xx:errors path="userInfor.regTime"></xx:errors></font>
								<td />
				</tr>
				<tr>
					<td rowspan="2">
						<input type="button" value="提交" onclick="checkInfor()"/>
					</td>
				</tr>
			</table>
		</form>

 
  </body>
</html>
