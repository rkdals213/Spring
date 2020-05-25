<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>REST테스트</title> 
  <style type="text/css">
     table{margin: auto;}
     td,th{padding: 5px}
  </style>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
  /*
  $.ajax({
   type:'POST',
   url:url,
   data:data,   -- json도 사용가능  
   success:success,
   dataType:datatype
});

※ 자주사용하는 속성
url:문자열 - 요청url 설정 ,데이터를 보내고자하는 주소   ex)  <form action="">
type:문자열 - GET/POST설정
data:객체,문자열 - 요청 매개변수 설정   ex) <input type="text"  name="irum">
dataType : 서버에서 내려온 data형식    ex) default : xml, json, script, text, html
success:함수 - 성공시 호출할 함수 설정
async:불리언 - 동기/비동기 설정
error:함수 - 실패시 호출할 함수 설정
  */
     $(document).ready(function(){
    	$('#showList').click(function(){
    		$.ajax({
    			type:'GET',
    			url:'/person/all',
    			dataType:'json',
    			success:function(data){ // [ {no : 1, name : 홍길동, age : 13, job : 학생},{no : 2, name : 김길동, age : 23, job : 학생}]
    				var htmlTxt='<ul>';
    				$.each(data,function(index,value){
    					 htmlTxt += '<li>'+value.name+'</li>';    					 
    				});
    				htmlTxt+='</ul>'
    				$('#list').html(htmlTxt);
    			}
    		});
    	});//목록보기
    	
    	$('#showForm').click(function(){
    		$.ajax({
    			type:'GET',
    			url:'/person/form',
    			success:function(data){    				
    				$('#form').html(data);
    			}
    		});
    	});//목록보기
    	
       	
    	
     });//ready
  </script>
</head>
 
<body>
  <h1>
	Hello world!  
  </h1>
  <P>  The time on the server is ${serverTime}. </P>
  
  <h3>REST테스트</h3>
  <button id="showList">사람목록보기</button> 
  <button id="showForm">사람입력</button>
  <hr>
  <div id="list"></div>  
  <div id="form"></div>
  <div id="result"></div>
</body>
</html>
