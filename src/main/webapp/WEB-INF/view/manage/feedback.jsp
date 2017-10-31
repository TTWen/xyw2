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
	<form action="/xyw2/manage/feedback" method="post">
		查看未读<input type="radio" name="fstate" value="0">
		查看全部<input type="radio" name="fstate" value="1">
		<input type="submit">
	</form>
	
	<c:forEach items="${fbList}" var="fb">
		<tr>
			<a href="/xyw2/manage/feedbackDetail/${fb.fid }">${fb.fid }</a>
			<th>时间<c:out value="${fb.ftime}" /></th>
			<th>联系方式<c:out value="${fb.ftel}" /></th>
		</tr>
	</c:forEach>


	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/manage/feedback/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/manage/feedback/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>