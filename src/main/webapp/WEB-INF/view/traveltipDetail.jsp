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
	<c:out value="${ttop.tt.ttuid }"></c:out>
	<c:out value="${ttop.tt.ttime }"></c:out>
	<c:out value="${ttop.tt.tttitle }"></c:out>
	<c:out value="${ttop.tt.ttcontent }"></c:out>
	
	<c:if test="${ttop.tt.ttuid == crtuid }">
		<a href="/xyw2/traveltip/delete/${ttop.tt.ttid }">删除</a>
	</c:if>
	<c:choose>
		<c:when test="${ttop.like == 0}">
			<th>
			<a href="/xyw2/user/likeTraveltip/${ttop.tt.ttid}">赞(${ttop.tt.ttlike })</a></th>
		</c:when>
		
		<c:otherwise>
			<th><a href="/xyw2/user/unlikeTraveltip/${ttop.tt.ttid}">取消赞(${ttop.tt.ttlike })</a></th>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${ttop.clt == 0}">
			<th><a href="/xyw2/user/cltTraveltip/${ttop.tt.ttid}">收藏</a></th>
		</c:when>
		
		<c:otherwise>
			<th><a href="/xyw2/user/uncltTraveltip/${ttop.tt.ttid}">取消收藏</a></th>
		</c:otherwise>
		
		
	</c:choose>
	</br></br>
	评论如下：
	</br>
	<c:forEach items="${ttDetailList }" var="ttd">
		<c:out value="${ttd.tpc.tpid }"></c:out>
		<c:out value="${ttd.tpc.tpuid }"></c:out>
		<c:out value="${ttd.tpc.tpcontent }"></c:out>
		<c:if test="${ttd.tpc.tpuid == crtuid }">
			<a href="/xyw2/user/deleteTopic/${ttd.tpc.tpid }">删除</a>
		</c:if>
		<a href="">回复</a></br>
		该评论的回复：</br>
		<c:forEach items="${ttd.rmk }" var="rmk">
			<c:out value="${rmk.rid }"></c:out>
			<c:out value="${rmk.ruid }"></c:out>
			<c:out value="${rmk.rduid }"></c:out>
			<c:out value="${rmk.rcontent }"></c:out>
			<c:if test="${rmk.ruid == crtuid }">
				<a href="/xyw2/user/deleteRemark/${rmk.rid }">删除</a>
			</c:if>
			<a href="">回复</a></br>
			
		</c:forEach>
		</br>
	</c:forEach>
	</br>
	
	
	<form action="/xyw2/user/addTopic" method="post">
		<input type="text" name="tpcontent"/>
		<input type="hidden" name="tpuid"  value="${crtuid }"/>
		<input type="hidden" name="tpttid"  value="${ttop.tt.ttid}"/>
		<input type="submit"/>
	</form>
	
	共
	<c:out value="${allPages}" />
	页
	<br> 当前页：
	<c:out value="${pageNow + 1}" />
	<br>
	<c:if test="${pageNow > 0}">
		<a href="/xyw2/traveltipDetail/${ttop.tt.ttid}/${pageNow - 1}">上</a>
	</c:if>

	<c:if test="${pageNow + 1 < allPages}">
		<a href="/xyw2/traveltipDetail/${ttop.tt.ttid}/${pageNow + 1}">下</a>
	</c:if>
	
</body>
</html>