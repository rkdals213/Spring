<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CRUD:수정폼</title>
  <style type="text/css">
     table{margin: auto;}
     td{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
  </style>  
  <script type="text/javascript">
     function removePerson(){
    	location.href='/person/delete?no=${person.no}';
     }
  </script>
</head>
<body>
  <h3>수정폼</h3>
  <hr>
    [<a href="/person/list">목록보기</a>]<br><br>
  <form action="/person/upform" method="post">
  	<input type="hidden" name="no" value="${person.no }"/>
    <table border="1">
      <tr>
         <td class="skyblue">이름</td>
         <td><input type="text" name="name" value="${person.name }"></td>
      </tr>
      <tr>
         <td class="skyblue">나이</td>
         <td><input type="text" name="age" value="${person.age }"></td>
      </tr>
      <tr>
         <td class="skyblue">직업</td>
         <td><input type="text" name="job" value="${person.job }"></td>
      </tr>
      <tr>
         <td colspan="2">
           <input type="submit" value="입력">
           <input type="reset" value="취소">
           <input type="button" value="삭제" onclick="removePerson()">
         </td>
      </tr>
    </table>
  </form>

</body>
</html>