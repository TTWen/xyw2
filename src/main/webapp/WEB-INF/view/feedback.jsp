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

	<form action="/xyw2/user/addFeedback" method="post">
		联系电话:<input type="text" name="ftel" /><br> 
		反馈内容:<textarea rows="" cols="" name="fcontent"></textarea>
		<input type="submit" />
	</form>
</body>
</html>