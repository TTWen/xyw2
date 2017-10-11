<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/ebook/manage/book/addBook" method="post"
		enctype="multipart/form-data">
		bname:<input type="text" name="bname" /><br> bauth:<input
			type="text" name="bauth" /><br> bpub:<input type="text"
			name="bpub" /><br> bpdate:<input type="text" name="bpdate" /><br>
		bisbn:<input type="text" name="bisbn" /><br> bpurpr:<input
			type="text" name="bpurpr" /><br> bsalepr:<input type="text"
			name="bsalepr" /><br> bstock:<input type="text" name="bstock" /><br>
		bpurnum:<input type="text" name="bpurnum" /><br> bsalenum:<input
			type="text" name="bsalenum" /><br> bexpl:<input type="text"
			name="bexpl" /><br> <input type="file" name="file"> <input
			type="submit" />
	</form>
</body>
</html>