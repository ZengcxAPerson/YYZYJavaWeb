<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginMessage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     	
     		<table border="1">
     			<tr>
     				<td>用户名</td>
     				<td>密码</td>
     				<td>用户角色</td>
     			</tr>
     		<c:forEach var="list" items="${loginList}" >
     			<tr>
     				<td>${list.loginName}</td>
     				<td>${list.loginPsw }</td>
     				<td>${list.loginPower }</td>
     			</tr>
     		</c:forEach>
     		</table>
     	
  </body>
</html>
