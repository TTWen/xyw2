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
	<c:if test="${crtmid == 1}">
		<a href="/ebook/manage/register">添加管理员</a>
		<a href="/ebook/manage/manager">管理员一览</a>
	</c:if>

	<a href="/ebook/manage/sort">分类管理</a>
</body>
</html>