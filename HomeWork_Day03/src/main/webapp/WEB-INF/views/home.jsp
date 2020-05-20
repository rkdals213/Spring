<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<h2>상품 등록</h2>
	<form method="post" action="/homework3/productregist">
		<input type="text" name ="id" placeholder="id">
		<input type="text" name ="name" placeholder="name">
		<input type="text" name ="price" placeholder="price">
		<input type="text" name ="description" placeholder="description">
		<input type="submit">
	</form>
	<a href="/homework3/productinfo">목록보기</a>
</body>
</html>
