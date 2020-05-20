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
	<c:forEach var="product" items="${productinfo}">
		<table class="table table-active">
			<tbody>
				<tr class="table-info">
					<td style="font-weight: bold">id : ${product.id}</td>
					<td style="font-weight: bold">name : ${product.name}</td>
					<td style="font-weight: bold">price : ${product.price}</td>
					<td style="font-weight: bold">des : ${product.description}</td>
				</tr>
			</tbody>
		</table>
	</c:forEach>
	<a href="/homework3">돌아가기</a>
</body>
</html>