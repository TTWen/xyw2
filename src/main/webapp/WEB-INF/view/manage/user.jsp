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
	<c:forEach items="${userList}" var="u">   
        <tr>  
            <th><c:out value="${u.uname}" /></th>   
            <th><c:out value="${u.upsw}" /></th>   
            <th><c:out value="${u.utel}" /></th>   
        </tr>
     </c:forEach>
     共<c:out value="${allPages}" />页
</body>
</html>