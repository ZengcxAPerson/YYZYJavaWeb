<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String t=(String)request.getSession().getAttribute("logintrue");
	if(t==null){
 %>
 <script type="text/javascript">
  	 alert("请先登录");
  	 location.href="index.jsp";
   
   </script>
 <%
 }
 request.removeAttribute("logintrue");
  %>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>腾达物流后台管理工作平台</title>
	<link rel="stylesheet" type="text/css" href="styles.css">

 </head>
 
<frameset rows="140,*,11" frameborder="no" border="0" framespacing="0">
	<frame src="top.jsp" name="topFrame" frameborder="5" scrolling="no" noresize="noresize" id="topFrame" />
	
	<frame src="center.html" name="mainFrame" frameborder="5" id="mainFrame" />
	<frame src="down.html" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
</frameset>
<noframes>
<body>
</body>
</noframes>
</html>
