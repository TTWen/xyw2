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
<form action="">
	<c:forEach items="${sortList}" var="s">   
        <tr>  
        	<th><input type="checkbox" name="sid" value="${s.sid}">id:<c:out value="${s.sid}" /></th>
            <th>sname：<c:out value="${s.sname}" /></th>   
        </tr>
     </c:forEach>
     <input type="submit" value="删除"/>
</form>

     <a href="/ebook/manage/sort/add">添加分类</a>
</body>
</html>