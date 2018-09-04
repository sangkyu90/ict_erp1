<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/depart/departList";
	}
</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<table class="table table-bordered">
			<tr>
				<th>부서번호</th>
				<td>${di.diNum}</td>
			</tr>
			<tr>
				<th>부서코드</th>
				<td>${di.diCode}</td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td>${di.diName}</td>
			</tr>
			<tr>
				<th>부서설명</th>
				<td>${di.diDesc}</td>
			</tr>
			<tr>
				<td colspan="2">
					<form action="/depart/departDelete" method="post">
						<button data-page="/depart/departUpdate?diNum=${di.diNum}">부서 수정</button>
						<button>부서삭제</button>
						<input type="hidden" name="diNum" value="${di.diNum}">
					</form>
				</td>
			</tr>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />