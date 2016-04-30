<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改客户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/WebCalendar.js"></script>  
  </head>
  
  <body style="text-align: center;">
  	<center><br/><br/>
	    <form id="submit" action="${pageContext.request.contextPath }/UpdateCustomerServlet" method="post">
	    	<input type="hidden" name="id" value="${customer.id }"/>
	    	<table border="1" width="60%">
	    		<tr>
	    			<td>姓名</td>
	    			<td><input type="text" name="name" value="${customer.name }"/></td>
	    		</tr>
	    		<tr>
	    			<td>性别</td>
	    			<td>
	    				<input type="radio" name="gender" value="1" ${customer.gender == '1' ? 'checked="checked"' : '' }/>男
	    				<input type="radio" name="gender" value="0" ${customer.gender == '0' ? 'checked="checked"' : '' }/>女
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>出生日期</td>
	    			<td><input type="text" name="birthday" value="${customer.birthday }" readonly="readonly" onClick="return SelectDate(this,'yyyy-MM-dd');"/></td>
	    		</tr>
	    		<tr>
	    			<td>手机</td>
	    			<td><input type="text" name="cellphone" value="${customer.cellphone }"/></td>
	    		</tr>
	    		<tr>
	    			<td>邮箱</td>
	    			<td><input type="text" name="email" value="${customer.email }"/></td>
	    		</tr>
	    		<tr>
	    			<td>爱好</td>
	    			<td>
	    				<c:forEach items="${hobby }" var="h">
	    					<input type="checkbox" name="hobbies" value="${h }" ${fn:contains(customer.hobby, h) ? 'checked="checked"' : '' }>${h }
	    				</c:forEach>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>客户类型</td>
	    			<td>
	    				<input type="radio" name="type" value="2" ${customer.type == 2 ? 'checked="checked"' : '' }/>VIP
	    				<input type="radio" name="type" value="1" ${customer.type == 1 ? 'checked="checked"' : '' }/>普通客户
	    				<input type="radio" name="type" value="0" ${customer.type == 0 ? 'checked="checked"' : '' }/>游客
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>描述</td>
	    			<td><textarea rows="5" cols="55" name="description">${customer.description }</textarea></td>
	    		</tr>
	    		<tr>
	    			<td colspan="2">
	    				<input type="button" value="保存" onclick="submitUpdate();"/>　　　　　　
	    				<input type="reset" value="重置"/>
	    			</td>
	    		</tr>
	    	</table>
	    </form>
    </center>
    
    <script type="text/javascript">
    	function submitUpdate() {
    		var submit = document.getElementById("submit");
    		var sure = window.confirm("确定要修改吗？");
    		if (sure) {
    			submit.submit();
    		}
    	}
    </script>
  </body>
</html>
