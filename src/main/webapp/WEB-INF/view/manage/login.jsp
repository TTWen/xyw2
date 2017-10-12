<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/xyw2/manage/doLogin" method="post">
		mname:<input type="text" name="mname" /> mpsw:<input type="password"
			name="mpsw" /> <input type="submit" />
	</form>
	${msg}
</body>
</html>