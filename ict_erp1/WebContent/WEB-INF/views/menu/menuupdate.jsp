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
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${a.meiNum}</td>
			</tr>
		
			<tr>
				<th>부서이름</th>
				<td>${a.meiName}</td>
			</tr>
			<tr>
				<th>부서설명</th>
				<td>${a.meiDesc}</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="/menu/menuDelete" method="post">
						<button data-page="/menu/menuUpdate?meiNum=${a.meiNum}">메뉴 수정</button>
						<button>메뉴삭제</button>
						<input type="hidden" name="meiNum" value="${a.meiNum}">
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />