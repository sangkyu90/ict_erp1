<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String rPath = request.getContextPath();
%>
	<nav aria-label="Page navigation example">
	  <ul class="pagination justify-content-center">
	  	<c:if test="${page.sBlock!=1}">
		  	<li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${page.sBlock-page.blockSize}" tabindex="-1">PRE</a>
		    </li>
		</c:if>
		<c:forEach	begin="${page.sBlock}" end="${page.lBlock}" var="p">
			<li class="page-item ${page.page eq p ? 'active':''}"><a class="page-link" href="<%=rPath%>/depart/departList?page=${p}">${p}</a></li>
		</c:forEach>
	    <c:if test="${page.lBlock!=page.totalPage}">
		    <li class="page-item">
		      <a class="page-link" href="<%=rPath%>/depart/departList?page=${page.sBlock+page.blockSize}">Next</a>
		    </li>
		</c:if>
	  </ul>
	</nav>