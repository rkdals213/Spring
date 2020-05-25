<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD:입력폼</title>
  <style type="text/css">
    /* 
     body{text-align: center} 
     */
     table{margin: auto;}
     td{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
  </style>
</head>
<body>
  <h3>입력폼</h3>
  <hr>
    [<a href="/person/list">목록보기</a>]<br><br>
  <form action="/person/form" method="post">
    <table border="1">
      <tr>
         <td class="skyblue">이름</td>
         <td><input type="text" name="name"></td>
      </tr>
      <tr>
         <td class="skyblue">나이</td>
         <td><input type="text" name="age"></td>
      </tr>
      <tr>
         <td class="skyblue">직업</td>
         <td><input type="text" name="job"></td>
      </tr>
      <tr>
         <td colspan="2">
           <input type="submit" value="입력">
           <input type="reset" value="취소">
         </td>
      </tr>
    </table>
  </form>

</body>
</html>