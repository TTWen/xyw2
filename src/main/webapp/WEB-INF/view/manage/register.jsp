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
	
	<c:if test="${crtmid != 1}">
		<jsp:forward page="/error"></jsp:forward>
	</c:if>
	<form action="doRegister" method="post">
			mname:<input type="text" name="mname" /><br> mpsw:<input
				type="password" name="mpsw" /><br> mpsw2:<input type="password"
				name="mpsw2" /><br> <input type="submit" /> mtel:<input
				type="text" name="mtel" /> memail:<input type="text" name="memail" />
	</form>
	
</body>
</html>