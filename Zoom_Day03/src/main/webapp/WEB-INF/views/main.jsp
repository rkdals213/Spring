<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>우리를 위한 환상의 공간</h1>
	<h2>사용자 : ${loginUser} </h2>
	
	<h2>우리 회원들의 명단은?</h2>
	<c:forEach var="userinfo" items="${userlist}">
		<table class="table table-active">
			<tbody>
				<tr class="table-info">
					<td style="font-weight: bold">${userinfo}</td>				
				</tr>
			</tbody>
		</table>
	</c:forEach>
</body>
</html>