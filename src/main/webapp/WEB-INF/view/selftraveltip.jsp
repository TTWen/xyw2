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


	<c:forEach items="${ttopList }" var="ttop">
		<tr>
		<a href="/xyw2/traveltipDetail/${ttop.tt.ttid}"><c:out value="${ttop.tt.ttid }"></c:out></a>
		
		<c:if test="${ttop.tt.ttuid == crtuid }">
		<a href="/xyw2/deleteTraveltip/${ttop.tt.ttid }">删除</a>
		<a href="/xyw2/modifyTraveltip/${ttop.tt.ttid }">修改</a>
		</c:if>
		
		
		<c:choose>
			<c:when test="${ttop.like == 0}">
				<th>
				<a href="/xyw2/user/likeTraveltip/${ttop.tt.ttid}">赞(${ttop.tt.ttlike })</a></th>
			</c:when>
			
			<c:otherwise>
				<th><a href="/xyw2/user/unlikeTraveltip/${ttop.tt.ttid}">取消赞(${ttop.tt.ttlike })</a></th>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${ttop.clt == 0}">
				<th><a href="/xyw2/user/cltTraveltip/${ttop.tt.ttid}">收藏</a></th>
			</c:when>
			
			<c:otherwise>
				<th><a href="/xyw2/user/uncltTraveltip/${ttop.tt.ttid}">取消收藏</a></th>
			</c:otherwise>
		</c:choose>
		
		
		</tr>
	</c:forEach><br><br>

	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/user/selfTraveltip/${ttuid }/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/user/selfTraveltip/${ttuid }/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>