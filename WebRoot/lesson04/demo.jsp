<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="xx"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

	document.forms[0].submit();
}
</script>
	</head>
	<body>
		<a href="${pageContext.request.contextPath}/mid?aa=zh_CN">Chinese</a>
		<a href="${pageContext.request.contextPath}/mid?aa=en_US">English</a>
		<form action="<%=path%>/demo3" method="post">
			<table border="1" align="center">
				<tr>
					<td>
						<tags:message code="userName"></tags:message>
						<td />
							<td>
								<input type="text" name="userName" />
								<font color=red><xx:errors path="userInfor.userName"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="password"></tags:message>
						<td />
							<td>
								<input type="password" name="password" />
								<font color=red><xx:errors path="userInfor.password"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="repassword"></tags:message>
						<td />
							<td>
								<input type="password" name="rePassword" />
								<font color=red><xx:errors path="userInfor.rePassword"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="email"></tags:message>
						<td />
							<td>
								<input type="text" name="email" />
								<font color=red><xx:errors path="userInfor.email"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="url"></tags:message>
						<td />
							<td>
								<input type="text" name="url" />
								<font color=red><xx:errors path="userInfor.url"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="phone"></tags:message>
						<td />
							<td>
								<input type="text" name="phone" />
								<font color=red><xx:errors path="userInfor.phone"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="age"></tags:message>
						<td />
							<td>
								<input type="text" name="age" />
								<font color=red><xx:errors path="userInfor.age"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td>
						<tags:message code="registrationTime"></tags:message>
						<td />
							<td>
								<input type="text" name="regTime" />
								<font color=red><xx:errors path="userInfor.regTime"></xx:errors>
								</font>
								<td />
				</tr>
				<tr>
					<td rowspan="2">

						<input type="button"
							value="<tags:message code='submit'></tags:message>"
							onclick="checkInfor()" />
					</td>
				</tr>
			</table>
		</form>


	</body>
</html>
