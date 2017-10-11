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
	<form action="/ebook/manage/modifyBook/${b.bid}" method="post">
		bname:
		<c:out value="${b.bname}" />
		<input type="text" name="bname" /><br> bauth:
		<c:out value="${b.bauth}" />
		<input type="text" name="bauth" /><br> bpub:
		<c:out value="${b.bpub}" />
		<input type="text" name="bpub" /><br> bpdate:
		<c:out value="${b.bpdate}" />
		<input type="text" name="bpdate" /><br> bisbn:
		<c:out value="${b.bisbn}" />
		<input type="text" name="bisbn" /><br> bpurpr:
		<c:out value="${b.bpurpr}" />
		<input type="text" name="bpurpr" /><br> bsalepr:
		<c:out value="${b.bsalepr}" />
		<input type="text" name="bsalepr" /><br> bstock:
		<c:out value="${b.bstock}" />
		<input type="text" name="bstock" /><br> bpurnum:
		<c:out value="${b.bpurnum}" />
		<input type="text" name="bpurnum" /><br> bsalenum:
		<c:out value="${b.bsalenum}" />
		<input type="text" name="bsalenum" /><br> bexpl:
		<c:out value="${b.bexpl}" />
		<input type="text" name="bexpl" /><br> <input type="submit" />
	</form>
</body>
</html>