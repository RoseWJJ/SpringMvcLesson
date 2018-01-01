<%@ tag language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@attribute  name="tokenName" required="false"%>

<%
	String ranStr = UUID.randomUUID().toString();
	String key=(tokenName==null?"myToken":tokenName);
	session.setAttribute(key,ranStr);
%>
<input type='hidden'  name='<%=key%>'  value='<%=ranStr %>'/>