
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/menu/menuList";
	}else{
		location.href="/menu/menuView?meiNum=<%=request.getParameter("meiNum")%>";
	}
</script>
</c:if>