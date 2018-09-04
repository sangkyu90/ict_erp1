
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/menu/menuList";
	}
</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<form action="/menu/menuInsert" method="post">
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td><input type="text" name="meiNum"></td>
			</tr>
			<tr>
				<th>메뉴이름</th>
				<td><input type="text" name="meiName"></td>
			</tr>
			<tr>
				<th>메뉴설명</th>
				<td><input type="text" name="meiDesc"></td>
			</tr>
			<tr>
				<td colspan="2"><button>메뉴등록</button></td>
			</tr>
		</table>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />