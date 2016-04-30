<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>TOP</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body style="text-align: center;">
    <h1>客户管理系统</h1>
    <a href="${pageContext.request.contextPath }/AddCustomerUIServlet" target="content">添加客户</a>
    <a href="${pageContext.request.contextPath }/ShowCustomerServlet" target="content">查看客户</a>
  </body>
</html>
