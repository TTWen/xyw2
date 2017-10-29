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
	<c:out value="${tt.ttuid }"></c:out>
	<c:out value="${tt.ttime }"></c:out>
	<c:out value="${tt.tttitle }"></c:out>
	<c:out value="${tt.ttcontent }"></c:out>
	<c:choose>
		<c:when test="${tt.ttischeck == 0 }">
			<a href="/xyw2/manage/checkPass/${tt.ttid }">审核通过</a>
			<a href="/xyw2/manage/checkUnpass/${tt.ttid }">不通过</a>
		</c:when>
		<c:otherwise>
			已通过
		</c:otherwise>
	</c:choose>
	
</body>
</html>