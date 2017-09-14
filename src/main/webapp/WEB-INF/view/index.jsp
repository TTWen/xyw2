<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<a href="/ebook/user/login">登录</a>
	<a href="/ebook/user/register">注册</a>
	<a href="/ebook/user/info/1">我的账户</a>
	<form action="/ebook/book/search" method="post">
		<input name="keyword"/>
	</form>
</body>
</html>