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
	<c:if test="${crtuid == null }">
		<jsp:forward page="/error"></jsp:forward>
	</c:if>
	<form action="/xyw2/traveltip/add" method="post" enctype="multipart/form-data">
		tttitle:<input type="text" name="tttitle" /><br> 
		<input type="file" name="file"><br>
		ttcity:<input type="text" name="ttcity" /><br>
		ttcontent:<textarea rows="" cols="" name="ttcontent"></textarea>
		<input type="hidden" name="ttuid" value="${crtuid }">
		<input type="submit" />
	</form>
</body>
</html>