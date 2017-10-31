<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>

	<c:choose>
		<c:when test="${crtuid == null}">
		
			<a href="/xyw2/user/login">登录</a>
			<a href="/xyw2/user/register">注册</a>
			
		</c:when>

		<c:otherwise>
			<a href="/xyw2/addTraveltip">发表攻略</a>
			<a href="/xyw2/user/info">个人信息</a>
			<a href="/xyw2/user/logout">注销</a>
			<a href="/xyw2/user/selfTraveltip/${crtuid }">个人攻略</a>
			<img src="${crtuser.uicon}">
			<form action="/xyw2/user/modifyIcon" method="post"
				enctype="multipart/form-data">
				<input type="file" name="file"> <input type="submit" />
			</form>
		</c:otherwise>
	</c:choose>
	<a href="/xyw2/user/feedback">反馈</a>
	<a href="/xyw2/user/traveltip">攻略库</a>
	<a href="/xyw2/user/scene">热门景点</a>
	
	<form action="/xyw2/search" method="post">
		<input name="keyword" type="text"/> <input type="submit">
		<input name="sort" type="hidden"/>
		<input name="city" type="hidden"/>
	</form>
</body>
</html>