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
	<a href="/xyw2/manage/addNotice">发布新公告</a>
	<form action="/xyw2/manage/deleteNotice" method="post">
		<c:forEach items="${noticeList}" var="n">
			<tr>
				<input type="checkbox" name="nid" value="${n.nid}">
				<th>nid:<c:out value="${n.nid}" /></th>
				<th>ntitle：<c:out value="${n.ntitle}" /></th>
			</tr>
		</c:forEach>
		<input type="submit" value="删除" />
	</form>

	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/manage/notice/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/manage/notice/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>