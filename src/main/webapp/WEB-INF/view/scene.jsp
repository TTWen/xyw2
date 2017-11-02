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
	热门：<br>
	<c:forEach var="h" items="${hotSceneList }">
		
	</c:forEach>
	
	
	
	<a href="/xyw2/user/scene/all">全部</a>
	<c:forEach var="l" items="${letter }">
		<a href="/xyw2/user/scene/${l }">${l }</a>
	</c:forEach>
	
	<c:forEach var="all" items="${allCity }">
		<c:if test="${all[0].sprovince == '' }">直辖市</c:if>
		${all[0].sprovince }:
		<c:forEach var="li" items="${all }">
			<a href="/xyw2/user/sceneDetail/${li.sid }">${li.scity }</a>
			&nbsp;
		</c:forEach>
		
	</c:forEach>
	
	<c:forEach var="c" items="${cityList }">
		<a href="/xyw2/user/sceneDetail/${c.sid }">${c.scity }</a>
	</c:forEach>
	
</body>
</html>