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
	<form action="/xyw2/user/modify" method="post">

		utel:<input type="text" name="utel" value="${crtuser.utel}" /><br>
		uemail:<input type="text" name="uemail" readonly="readonly"
			value="${crtuser.uemail}" /><br> ubirth:<input type="text"
			name="ubirth" value="${crtuser.ubirth}" /><br> usignature:<input
			type="text" name="usignature" value="${crtuser.usignature}" /> <input
			type="submit" />
	</form>
</body>
</html>