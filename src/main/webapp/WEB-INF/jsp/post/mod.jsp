<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MOD</title>
</head>
<body>
	<h1>MOD</h1>
	<form:form method="post" commandName="post" id="form">
		<label>subject</label> <input type="text" name="subject" value="${post.subject }"><form:errors path="subject" /><br>
		<label>content</label> <input type="text" name="content" value="${post.content }"><form:errors path="content" /><br>
		<input type="submit" value="수정">		
		<input type="hidden" name="id" value="${post.id }">
	</form:form>
	<a href="../list">리스트</a>
</body>
<script>
	$("#form").submit(function () {
		if( ! $("input[name=subject]").val()) {
			alert("필수");
			$("input[name=subject]").focus();	
			return false;
		}
	});

</script>
</html>