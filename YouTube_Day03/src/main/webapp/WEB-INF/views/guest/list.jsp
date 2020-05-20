<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록:리스트</title>
  <style type="text/css">
     body{text-align: center}
     table{margin: auto;}
     td,th{padding: 5px}
  </style>
</head>
<body>
  <h3>방명록:리스트</h3>
  <hr>
   <a href="/day03/guest/form">방명록 쓰기</a><br><br>
  <form>
  
    <table border="1">
      <tr style="background-color: skyblue">
         <th>번호</th>
         <th>작성자</th>
         <th>전화번호</th>
         <th>작성일</th>
         <th>내용</th>
      </tr>

     
    <c:forEach items="${list }" var="guest">      
      <tr>
         <td>${guest.no }</td>
         <td>${guest.writer }</td>
         <td>${guest.tel }</td>
     <%--<td><fmt:formatDate value="${guest.wdate }" pattern="yyyy/MM/dd HH:mm:ss"/> </td> --%>
         <td><fmt:formatDate value="${guest.wdate }" pattern="yyyy-MM-dd"/> </td>
         <td><a href="/day03/guest/upform?no=${guest.no }">${guest.contents }</a></td>
         <%--
               JSP(자바)요소 중  HTML 또는 JavaScript와 어울릴 수 있는 요소는?
               ==> 표현식(출력식)!!
               ==> Expression <%= %>    Expression Language   ${  }
          --%>
      </tr>
     </c:forEach>
    </table>
  </form>
  <br>
     
   
  
</body>
</html>




