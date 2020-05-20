<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/homeworkday3/productregist">
		<input type="text" name ="id" placeholder="id">
		<input type="text" name ="name" placeholder="name">
		<input type="text" name ="price" placeholder="price">
		<input type="text" name ="description" placeholder="description">
		<input type="submit">
	</form>
	<a href="/homeworkday3/productinfo">목록보기</a>
</body>
</html>