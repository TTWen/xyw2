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

	<c:if test="${crtmid == null }">
		<jsp:forward page="/error"></jsp:forward>
	</c:if>

	<a href="/xyw2/manage/scene/add">添加景点</a>
	
	<c:forEach items="${sceneList}" var="s">
		<tr>
			<th>sid:<c:out value="${s.sid}" /></th>
			<th>scity：<c:out value="${s.scity}" /></th>
			<th>sprovince：<c:out value="${s.sprovince}" /></th>
			<a href="/xyw2/manage/scene/modify/${s.sid }">修改</a>
			<a href="/xyw2/manage/scene/delete/${s.sid }">删除</a>
		</tr>
	</c:forEach>



	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/manage/scene/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/manage/scene/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>