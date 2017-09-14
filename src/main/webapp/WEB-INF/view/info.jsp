<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/ebook/user/modify/1" method="post">
		uname:<c:out value="${user.uname}" /><input type="text" name="uname"/><br>
		utel:<c:out value="${user.utel}" /><input type="text" name="utel"/><br>
		uem:<c:out value="${user.uem}" /><input type="text" name="uem"/><br>
		uad:<c:out value="${user.uad}" /><input type="text" name="uad"/><br>
		uurl:<c:out value="${user.uurl}" /><input type="text" name="uurl"/><br>
		<input type="submit"/>
	</form>
</body>
</html>