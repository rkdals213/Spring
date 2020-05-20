<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록:수정폼</title>
  <style type="text/css">
     body{text-align: center}
     table{margin: auto;}
     td{padding: 5px}
     .skyblue{background-color: skyblue;
              width: 80px;
              text-align: left}
  </style>  
</head>
<body>
  <h3>수정폼</h3>
  <hr>
    [<a href="/day03/guest/list">게시물 목록으로</a>]<br><br>
  <form action="/day03/guest/upform" method="post"
        name="editForm">
    <table border="1">
      <tr>
         <td class="skyblue">작성자</td>
         <td><input type="text" name="writer"
                    value="${guest.writer }" readonly></td>
      </tr>
      <tr>
         <td class="skyblue">email</td>
         <td><input type="text" name="email" value="${guest.email }"></td>
      </tr>
      <tr>
         <td class="skyblue">전화번호</td>
         <td><input type="text" name="tel"  value="${guest.tel }"></td>
      </tr>
      <tr>
         <td class="skyblue">비밀번호</td>
         <td><input type="password" name="pass"  value="${guest.pass }"></td>
      </tr>
      <tr>
         <td colspan="2"><textarea rows="5" cols="35"
         name="contents">${guest.contents }</textarea></td>
      </tr>
      <tr>
         <td colspan="2">
           <input type="submit" value="수정" >
           <input type="reset" value="취소">
           <input type="button" value="삭제">
         </td>
      </tr>
    </table>
  </form>

</body>
</html>