<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<c:url value="/" var="root" />
</head>
<body>
	<h1 align="center">Welcome To SSAFY</h1>
	<h2>상품 목록</h2>	
	<button id="selectAll">목록보기</button>
	<ul id="products">
	</ul>
	<h3>상세 정보</h3>
	<form id="product">
		ID : <input type="text" id="id" name="id"> <br>
		NAME : <input type="text" id="name" name="name"> <br>
		PRICE : <input type="text" id="price" name="price"> <br>
		<input type="text" id="des" name="des" style="width:800px; height:40px;"> <br>
	</form>
	<button id="add">추가</button>
	<button id="mod">수정</button>
	<button id="del">삭제</button>
</body>
<script>
	$("#selectAll").on("click", function() {
		loadProducts();
	});
	
	$("#add").on("click", function() {
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
	
	$("#del").on("click", function() {
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

	$("#mod").on("click", function() {
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

	$(document).on("click", ".item", function() {
		let id = $(this).attr("ID");
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
					$("#products").empty();
					$.each(result.data, function(idx, item) {
						console.log(idx, item);
						$("#products").append(
								"<li class='item' ID='"+item.id+"'>"
										+ item.id);
					});
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
		let fields = $("#product>input");
		$.each(fields, function(idx, field) {
			obj[field.id] = field.value;
		});
		return JSON.stringify(obj);
	}
</script>
</html>
