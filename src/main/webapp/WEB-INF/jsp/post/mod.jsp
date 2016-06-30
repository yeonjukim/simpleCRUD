<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MOD</title>
</head>
<body>
	<h1>MOD</h1>
	<form action="./mod" method="post">
		<label>subject</label> <input type="text" name="subject" value="${post.subject }"><br>
		<label>content</label> <input type="text" name="content" value="${post.content }"><br>
		<input type="submit" value="수정">
		<input type="hidden" name="id" value="${post.id }">
	</form>
	<a href="../list">리스트</a>
</body>
</html>