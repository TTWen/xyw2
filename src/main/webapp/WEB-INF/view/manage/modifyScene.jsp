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
	
	<form action="/xyw2/manage/modifyScene" method="post" enctype="multipart/form-data">
		sprovince:<input type="text" name="sprovince" value="${scene.sprovince}" /><br> 
		scity:<input type="text" name="scity" value="${scene.scity }"/><br>
		<img alt="" src="${scene.spic }">
		<input type="file" name="file"/><br>
		sintrod:<textarea rows="" cols="" name="sintrod" >${scene.sintrod}</textarea>
		<input type="hidden" name="sid" value="${scene.sid }">
		<input type="submit" />
	</form>
</body>
</html>