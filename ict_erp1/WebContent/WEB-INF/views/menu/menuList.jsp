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
					<th>이름</th>
					<th>가격</th>
					<th>메뉴설명</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${menuList}" var="a">
				<tr>
					<td>${a.meiNum}</td>
					<td><a href="/menu/menuView?meiNum=${a.meiNum}">${a.meiName}</a></td>
					<td>${a.meiPrice}</td>
					<td>${a.meiDesc}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="btns">
			<button data-page="/views/menu/menuInsert">메뉴등록</button>
		</div>
		<div class="page" style="text-align:center">
			<jsp:include page="/WEB-INF/views/menu/pagination.jsp"></jsp:include>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />