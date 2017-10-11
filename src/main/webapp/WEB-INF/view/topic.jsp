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
	<form action="/ebook/user/addTopic" method="post">

		<input type="text" name="tcontent" /> <input type="submit"
			value="发表留言" />
	</form>

	<c:forEach items="${topicList}" var="t">
		<tr>
			<th>tid:<c:out value="${t.tid}" /></th>
			<th>tuid：<c:out value="${t.tuid}" /></th>
			<th>tcontent：<c:out value="${t.tcontent}" /></th>
			<th>ttime：<c:out value="${t.ttime}" /></th>

		</tr>
		<form action="/ebook/user/addRemark" method="post">

			<input type="text" name="rcontent" /> <input type="hidden"
				name="rtid" value="${t.tid}" /> <input type="submit" value="回复" />
		</form>
	</c:forEach>

	<c:forEach items="${remarkList }" var="rli">

		<c:forEach items="${rli }" var="r">
        		rid:<c:out value="${r.rid }"></c:out>
			<c:if test="${r.rsta == 1 }">
				管理员:<c:out value="${r.rtoid }:"></c:out>
			</c:if>

			<c:if test="${r.rsta == 0 }">
				用户:<c:out value="${r.rtoid }:"></c:out>
			</c:if>
			<c:out value="${r.rcontent }"></c:out>
			</br>
			<c:out value="${r.rtime }"></c:out>
			</br>
		</c:forEach>
	</c:forEach>



	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow != 0}">
		<a href="/ebook/user/topic/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 != allPages}">
		<a href="/ebook/user/topic/${pageNow + 1}">下</a>
	</c:if>
</body>
</html>