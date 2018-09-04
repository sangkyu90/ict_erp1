<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름 </th>
					<th>부서코드</th>
					<th>부서명</th>
					<th>권한레벨</th>
					<th>권한명</th>
					<th>이메일</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
			<c:if test="${empty miList}">
				<tr>
					<td colspan="7">등록된 사원이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${miList}" var="mi">
				<tr>
					<td>${mi.miNum}</td>
					<td>${mi.miId}</td>
					<td>${mi.miName}</td>
					<td>${mi.diCode}</td>
					<td>${mi.diName}</td>
					<td>${mi.liLevel}</td>
					<td>${mi.liName}</td>
					<td>${mi.miEmail}</td>
					<td>${mi.miPhone}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />