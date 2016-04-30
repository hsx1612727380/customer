<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	 共${page.totalRecord }条记录 &nbsp;&nbsp;${page.pageNum }/${page.totalPage }&nbsp;&nbsp;
   	<a href="${pageContext.request.contextPath }/${page.servletName }?pageNum=1">[首页]</a>&nbsp;&nbsp;
   	<a href="${pageContext.request.contextPath }/${page.servletName }?pageNum=${page.pageNum - 1 > 0 ? page.pageNum - 1 : 1 }">[前一页]</a>&nbsp;&nbsp;
    <c:forEach begin="${page.startPage }" end="${page.endPage }" var="pageNumber">
    	[<a href="${pageContext.request.contextPath }/${page.servletName }?pageNum=${pageNumber}">${pageNumber }</a>]   
    </c:forEach>
   	&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/${page.servletName }?pageNum=${page.pageNum + 1 < page.totalPage ? page.pageNum + 1 : page.totalPage }">[后一页]</a>
   	&nbsp;&nbsp;<a href="${pageContext.request.contextPath }/${page.servletName }?pageNum=${page.totalPage }">[尾页]</a>
  		&nbsp;&nbsp;<input id="pageNu" type="text" name="pageNu" size="3"/><input type="button" value="go" onclick="toPageNu(document.getElementById('pageNu'));"/>
   	<script type="text/javascript">
   		function toPageNu(inputObject) {
   			var pageValue = inputObject.value;
   			// 验证用户的输入
   			// 用户什么都没有输入，提示请输入页数
   			if (pageValue == null || pageValue == "") {
   				alert("请输入页数");
   				return;
   			} 
   			// 用户输入的是非数字，提示请输入数字
   			if (!pageValue.match("\\d+")) {
   				alert("输入正确的页数");
   				inputObject.value = "";
   				return;
   			}
   			// 用户输入的数字不在页数的范围内， 1 < ? < totalPage
   			if ((pageValue < 1) || (pageValue > ${page.totalPage})) {
   				alert("输入正确的页数");
   				inputObject.value = "";
   				return;
   			}
   			window.location.href="${pageContext.request.contextPath}/${page.servletName }?pageNum=" + pageValue;
   		}
   	</script>