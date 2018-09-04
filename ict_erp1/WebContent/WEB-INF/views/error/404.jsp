<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<%
			out.println("요청하신 주소는 존재하지 않습니다.<br>");
		%>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />