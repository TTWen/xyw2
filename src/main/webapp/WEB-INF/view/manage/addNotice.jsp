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
	<form action="/xyw2/manage/notice/add" method="post">
		ntitle:<input type="text" name="ntitle" /><br> 
		ncontent:<textarea rows="" cols="" name="ncontent"></textarea>
		<input type="hidden" name="nmid" value="${crtmid }">
		<input type="submit" />
	</form>
</body>
</html>