<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>客户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body style="text-align: center;">
  	<center>
	    <h3>客户列表</h3>
	    <input type="button" value="删&nbsp;&nbsp;除" onclick="toDelete();"/><br/><br/>
	    <form id="form1" action="${pageContext.request.contextPath}/DeleteCustomerServlet" method="post">
		    <table width="80%" border="1">
		    	<tr>
		    		<th nowrap="nowrap">选择</th>
		    		<th nowrap="nowrap">序号</th>
		    		<th nowrap="nowrap">姓名</th>
		    		<th nowrap="nowrap">性别</th>
		    		<th nowrap="nowrap">出生日期</th>
		    		<th nowrap="nowrap">手机</th>
		    		<th nowrap="nowrap">邮箱</th>
		    		<th nowrap="nowrap">爱好</th>
		    		<th nowrap="nowrap">客户类型</th>
		    		<th nowrap="nowrap">描述</th>
		    		<th nowrap="nowrap">操作</th>
		    	</tr>
		    	<c:forEach items="${page.list }" var="customer" varStatus="status">
		    		<tr>
		    			<td nowrap="nowrap"><input type="checkbox" name="ids" value="${customer.id }"/></td>
		    			<td nowrap="nowrap">${status.count }</td>
		    			<td nowrap="nowrap">${customer.name }</td>
		    			<td nowrap="nowrap">${customer.gender == '1' ? '男' : '女' }</td>
		    			<td nowrap="nowrap">${customer.birthday }</td>
		    			<td nowrap="nowrap">${customer.cellphone }</td>
		    			<td nowrap="nowrap">${customer.email }</td>
		    			<td nowrap="nowrap">${customer.hobby }</td>
		    			<td nowrap="nowrap">${customer.type == '2' ? 'VIP' : customer.type == '1' ? '普通客户' : '游客'}</td>
		    			<td nowrap="nowrap">${customer.description }</td>
		    			<td nowrap="nowrap">
		    				<a href="${pageContext.request.contextPath }/UpdateCustomerUIServlet?id=${customer.id}">修改</a>
		    			</td>
		    		</tr>
		    	</c:forEach>
		    </table>
	    </form>
	    <br/>
	   	<%@include file="/public/page.jsp" %>
    </center>
    <script type="text/javascript">
    	function toDelete() {
    		var idsObject = document.getElementsByName("ids");
    		var isSelected = false;
    		// 先判断用户是否"选择"了
    		for (var i = 0; i < idsObject.length; i++) {
    			if (idsObject[i].checked) {
    				isSelected = true;
    				break;
    			}
    		}
    		// 没有选择，给用户提示"请选择要删除的记录"
    		if (!isSelected) {
    			alert("请先选择要删除的记录");
    		}
    		// 如果选择了任何一个，给用户提示"确定要删除吗？"
    		if (isSelected) {
    			var sure = window.confirm("确定要删除吗？");
    			if (sure) {
    				document.getElementById("form1").submit();
    			}
    		}
    	}
    </script>
  </body>
</html>
