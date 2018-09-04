
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
		<form action="/member/memberInsert" method="post">
		<table class="table table-bordered">
			<tr>
				<th>사원아이디</th>
				<td><input type="text" name="miId"></td>
			</tr>
			<tr>
				<th>사원비밀번호</th>
				<td><input type="password" name="miPwd"></td>
			</tr>
			<tr>
				<th>사원이름</th>
				<td><input type="text" name="miName"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="miEmail"></td>
			</tr>
			<tr>
				<th>폰번호</th>
				<td><input type="number" name="miPhone"></td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td><input type="number" name="miZipcode"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="miAddress1"></td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td><input type="text" name="miAddress2"></td>
			</tr>
			<tr>
				<th>부서</th>
				<td>
					<select name="diCode">
						<option>선택</option>
						<c:forEach items="${diList}" var="di">
							<option value="${di.diCode}">${di.diName}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<th>권한</th>
				<td>
					<select name="liLevel">
						<option>선택</option>
						<c:forEach items="${liList}" var="li">
							<option value="${li.liLevel}">${li.liName}</option>
						</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<th>상세정보</th>
				<td><input type="text" name="miDesc"></td>
			</tr>
			<tr>
				<td colspan="2"><button>부서등록</button></td>
			</tr>
		</table>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />