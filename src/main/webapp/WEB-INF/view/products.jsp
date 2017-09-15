<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${bookList}" var="b">   
        <tr>  
            <th>bname:<c:out value="${b.bname}" /></th>   
            <th>burl:<c:out value="${b.bsalenum}" /></th>  
            <th>bsalepr:<c:out value="${b.bsalepr}" /></th>   <br>
        </tr>
     </c:forEach>
共<c:out value="${allPages}" />页<br>
当前页：<c:out value="${pageNow + 1}" /><br>
<c:if test="${pageNow != 0}">
	<a href="/ebook/products/${pageNow - 1}">上</a>
</c:if>

<c:if test="${pageNow + 1 < allPages}">
	<a href="/ebook/products/${pageNow + 1}">下</a>
</c:if>
</body>
</html>