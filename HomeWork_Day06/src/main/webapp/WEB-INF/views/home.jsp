<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url value="/" var="root" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
td, th {
	padding: 5px;
	align-self: center;
}

.skyblue {
	background-color: skyblue;
	width: 80px;
	text-align: left;
}

table{
	border: 1px;
	width: 80%;
	align-content: center;
}
</style>
</head>
<body>
	<h1 align="center">Product</h1>
	<div id="list">
		
	</div>
	<div>
		<form id="inputform" >
			ID : <input type="text" id="id" name="id"/><br>
			NAME : <input type="text" id="name" name="name"/><br>
			PRICE : <input type="text" id="price" name="price"/><br>
			DES : <input type="text" id="des" name="des"/><br>
		</form>
		<button id="bt_input">추가</button>
		<button id="bt_mod">수정</button>
		<button id="bt_delete">삭제</button>
	</div>
</body>
<script>
	$("#selectAll").on("click", function() {
		loadProducts();
	});
	
	$("#bt_input").on("click", function() {
		console.log("add");
		$.ajax({
			type : "post",
			contentType:"application/json;charset=utf-8",
			url : "${root}product",
			data : formToJson(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadProducts();
				} else {
					alert("추가 실패");
				}
			},
			error : function() {
				alert("추가 실패");
			}
		});
	});
	
	$("#bt_delete").on("click", function() {
		$.ajax({
			type : "delete",
			url : "${root}product/" + $("#id").val(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadProducts();
				} else {
					alert("삭제 실패");
				}
			},
			error : function() {
				alert("삭제 실패");
			}
		});
	});

	$("#bt_mod").on("click", function() {
		$.ajax({
			type : "put",
			contentType:"application/json;charset=utf-8",
			url : "${root}product",
			data : formToJson(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadProducts();
				} else {
					alert("수정 실패");
				}
			},
			error : function() {
				alert("수정 실패");
			}
		});
	});
	
	$(document).on("click", "#choose", function() {
		let id = $(this).attr("name");
		console.log(id)

		$.ajax({
			type : "get",
			url : "${root}product/" + id,
			success : function(result) {
				if (result.status) {
					$("#id").val(result.data.id);
					$("#name").val(result.data.name);
					$("#price").val(result.data.price);
					$("#des").val(result.data.des);
				}
			},
			error : function() {
				alert("잠시 서버 이상으로 사용자 목록 조회 실패. 잠시후 다시 시도?");
			}
		})
	})
	
	function loadProducts() {
		$.ajax({
			type : "get",
			url : "${root}product",
			success : function(result) {
				if (result.status) {
					$("#list").empty();
					var htmlTxt = '<table><tr class="skyblue"><td>ID</td><td>NAME</td><td>PRICE</td><td>DES</td><td>CHOOSE</td></tr>'							
					$.each(result.data, function(index, value) {
						htmlTxt += '<tr><td>'
								+ value.id + '</td><td>'
								+ value.name + '</td><td>' 
								+ value.price + '</td><td>'
								+ value.des + '</td><td>'
								+ '<button id="choose" name="'+value.id+'">선택</button></td><td>';
					});
					
					htmlTxt += '</tr></table>'
					$('#list').html(htmlTxt);
				}
			},
			error : function() {
				alert("잠시 서버 이상으로 목록 조회 실패. 잠시후 다시 시도?");
			}
		});
	}

	loadProducts();
	
	function formToJson() {
		let obj = {};
		let fields = $("#inputform>input");
		$.each(fields, function(idx, field) {
			obj[field.id] = field.value;
		});
		return JSON.stringify(obj);
	}
</script>
</html>