<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD:리스트</title>
  <style type="text/css">
     table{margin: auto;}
     td,th{padding: 5px}
  </style>
</head>
<body>
  <h3>CRUD:리스트</h3>
  <hr>
   <a href="/person/form">사람정보 쓰기</a><br><br>
  <form>
  
    <table border="1">
      <tr style="background-color: skyblue">
         <th>번호</th>
         <th>이름</th>
         <th>나이</th>
         <th>직업</th>
      </tr>      
    <c:forEach items="${list }" var="person">      
      <tr>
         <td>${person.no }</td>
         <td><a href="/person/upform?no=${person.no }">${person.name }</a></td>
         <td>${person.age }</td>
         <td>${person.job }</td>
      </tr>
     </c:forEach>
    </table>
  </form>
  <br>
     
   
  
</body>
</html>




