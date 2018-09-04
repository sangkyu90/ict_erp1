
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
					<th>부서코드</th>
					<th>부서명</th>
					<th>부서설명</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${diList}" var="di">
				<tr>
					<td>${di.diNum}</td>
					<td><a href="/depart/departView?diNum=${di.diNum}">${di.diCode}</a></td>
					<td>${di.diName}</td>
					<td>${di.diDsc}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="btns">
			<button data-page="/views/depart/departInsert">부서등록</button>
		</div>
		<div class="page" style="text-align:center">
			<jsp:include page="/WEB-INF/views/menu/pagination.jsp"></jsp:include>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />