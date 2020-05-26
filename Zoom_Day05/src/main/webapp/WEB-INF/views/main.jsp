<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table{
		border-collapse: collapse;
	}
	th{
		background: gray;
	}
	
	td{
		border: 1px dotted blue;
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>우리를 위한 환상의 공간..</h1>
	<h2>사용자 : ${loginUser }</h2>

	<h2>우리 회원들의 명단은?</h2>
	<table>
		<tr>
			<th>아이디</th>
			<th>비번</th>
		</tr>
		<c:forEach items="${users }" var="user">
		<tr>
			<td>${user.userid }</td>
			<td>${user.pass }</td>
		</tr>
	</c:forEach>
	</table>

</body>
</html>