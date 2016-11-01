<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + 
		request.getServerPort() + "/chengcheng/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>"/> 
<title>空闲教室</title>
</head>
<body>
<center>
<p>空闲教室列表</p>
<table border="1" bgcolor="green">
<s:iterator value="rooms" var="room">
	<tr>
	<td><s:property value="#room.roomId" /></td>
	</tr>
</s:iterator>
</table>
</center>
</body>
</html>