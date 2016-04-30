<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/WebCalendar.js"></script>  
  </head>
  
  <body style="text-align: center;">
  	<center><br/><br/>
	    <form action="${pageContext.request.contextPath }/AddCustomerServlet" method="post">
	    	<table border="1" width="60%">
	    		<tr>
	    			<td>姓名</td>
	    			<td><input type="text" name="name"/></td>
	    		</tr>
	    		<tr>
	    			<td>性别</td>
	    			<td>
	    				<input type="radio" name="gender" value="1"/>男
	    				<input type="radio" name="gender" value="0"/>女
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>出生日期</td>
	    			<td><input type="text" name="birthday" readonly="readonly" onClick="return SelectDate(this,'yyyy-MM-dd');"/></td>
	    		</tr>
	    		<tr>
	    			<td>手机</td>
	    			<td><input type="text" name="cellphone"/></td>
	    		</tr>
	    		<tr>
	    			<td>邮箱</td>
	    			<td><input type="text" name="email"/></td>
	    		</tr>
	    		<tr>
	    			<td>爱好</td>
	    			<td>
	    				<c:forEach items="${hobby }" var="h">
	    					<input type="checkbox" name="hobbies" value="${h }">${h }
	    				</c:forEach>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>客户类型</td>
	    			<td>
	    				<input type="radio" name="type" value="2"/>VIP
	    				<input type="radio" name="type" value="1"/>普通客户
	    				<input type="radio" name="type" value="0"/>游客
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>描述</td>
	    			<td><textarea rows="5" cols="55" name="description"></textarea></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
	    				<input type="submit" value="保存"/>　　　　　　
	    				<input type="reset" value="重置"/>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
    	</center>
  </body>
</html>
