<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<c:url value="/" var="root" />
<link rel="stylesheet" href="${root }resources/css/common.css" />
</head>
<body>
	
	<h1>Hello world!</h1>
	<P id="title">The time on the server is ${serverTime}.</P>
	<img src="${root }resources/ssafy.png" alt="" />
	<h2>login</h2>
	<form method="post" action="${root }login">
		<input type="text" name="userid"><input type="password" name="pass"/>
		<br>
		<input type="submit" />
	</form>
</body>
</html>
