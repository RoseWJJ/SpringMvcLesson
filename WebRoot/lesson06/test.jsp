<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>Query</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript">
function query() {
	//无刷新调用 http://localhost:8080/springmvc/showFood3获取到数据 通过dom方式添加到table中
	//ajax（异步）+json

	var xmlhttp;
	//兼容所有的浏览器来创建对象；
	if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp = new XMLHttpRequest();
	} else {// code for IE6, IE5
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}

	//用来接收数据  回调函数
	xmlhttp.onreadystatechange = function() {
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	   		 {
	   			 var table = document.getElementById("mytable");
	   		 	//返回的是字符串的json
	   			var resultJson =xmlhttp.responseText;
	   			//将字符串转成对象；
	   			var resultObj = JSON.parse(resultJson);
	   			//获取表格对象；
	   			var dataTr = document.getElementsByName("dataTr");
	   			var xlength = dataTr.length;
	   			for(var i=0;i<xlength;i++){
	   				table.removeChild(dataTr[0]);
	   			}
	   			
	   			
	   			for(var i = 0;i<resultObj.length;i++){
	   				var obj  = resultObj[i];
	   				var tr = document.createElement("tr");
	   				tr.setAttribute("name","dataTr");
	   				var td1 = document.createElement("td");
	   				td1.innerText=obj.foodname;
	   				var td2 = document.createElement("td");
	   				td2.innerText=obj.price;
	   				tr.appendChild(td1);	
	   				tr.appendChild(td2);
	   				table.appendChild(tr);
	   				
	   			}
	   			
	    	 }
 		 }
 		var foodname = document.getElementsByName("foodname")[0].value;
 		 //open表示产生一个请求的关联（get提交）
		xmlhttp.open("GET","${pageContext.request.contextPath}/showFood3/?foodname="+foodname,true);
		xmlhttp.send();
		}
		
	</script>
	</head>

	<body>

		<input type='text' name="foodname"/>
		<input type="submit" value="查询" onclick="query()"/>
		<table id="mytable">
			<tr>
				<th>
					菜名
				</th>
				<th>
					价格
				</th>
			</tr>
		</table>

	</body>
</html>
