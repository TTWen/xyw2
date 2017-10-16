<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${ttopList }" var="li">
		<tr>
		<c:out value="${li.tt.ttid }"></c:out>

		<c:choose>
			<c:when test="${li.like == 0}">
				<th>
				<a href="/xyw2/user/likeTraveltip/${li.tt.ttid}">赞(${li.tt.ttlike })</a></th>
			</c:when>
			
			<c:otherwise>
				<th><a href="/xyw2/user/unlikeTraveltip/${li.tt.ttid}">取消赞</a></th>
			</c:otherwise>
		</c:choose>
		
			<th><a href="/xyw2/user/uncltTraveltip/${li.tt.ttid}">取消收藏</a></th>

		</tr>
	</c:forEach><br><br>

	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/user/ttclt/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/user/ttclt/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>