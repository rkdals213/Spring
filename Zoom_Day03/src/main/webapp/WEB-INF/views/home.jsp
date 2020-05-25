<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<title>Home</title>
<c:url value="/" var="root" />
<link rel="stylesheet" href="${root }resources/css/common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Hello world!</h1>
	<P id="title">The time on the server is ${serverTime}.</P>
	<img src="${root }resources/ssafy.png">
	<h1>로그인</h1>
	<form method="post" action="${root }login">
		<input type="text" name="userid">
		<input type="password" name="pass">
		<br>
		<input type="submit">
	</form>

	<h1>사용자 목록</h1>
	<ul id="users">

	</ul>

	<h1>사용자 상세 정보</h1>
	<form id="user">
		<input type="text" id="userid" name="userid">
		<input type="text" id="pass" name="pass">
		<br>
	</form>
	<button id="add">추가</button>
	<button id="mod">수정</button>
	<button id="del">삭제</button>

	<c:url value="/" var="root"></c:url>
</body>
<script>
	$("#add").on("click", function() {
		$.ajax({
			type : "post",
			contentType:"application/json;charset=utf-8",
			url : "${root}user",
			data : formToJson(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadUsers();
				} else {
					alert("사용자 추가 실패");
				}
			},
			error : function() {
				alert("사용자 추가 실패");
			}
		});
	});

	$("#del").on("click", function() {
		$.ajax({
			type : "delete",
			url : "${root}user/" + $("#userid").val(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadUsers();
				} else {
					alert("사용자 삭제 실패");
				}
			},
			error : function() {
				alert("사용자 삭제 실패");
			}
		});
	});

	$("#mod").on("click", function() {
		$.ajax({
			type : "put",
			contentType:"application/json;charset=utf-8",
			url : "${root}user",
			data : formToJson(),
			success : function(result) {
				if (result.status) {
					alert(result.data);
					loadUsers();
				} else {
					alert("사용자 수정 실패");
				}
			},
			error : function() {
				alert("사용자 수정 실패");
			}
		});
	});

	//http://localhost:8080/zoomday3/user/henry
	function loadUsers() {
		$.ajax({
			type : "get",
			url : "${root}user",
			success : function(result) {
				if (result.status) {
					$("#users").empty();
					$.each(result.data, function(idx, item) {
						console.log(idx, item);
						$("#users").append(
								"<li class='item' user='"+item.userid+"'>"
										+ item.userid + ", " + item.pass);
					});
				}
			},
			error : function() {
				alert("잠시 서버 이상으로 사용자 목록 조회 실패. 잠시후 다시 시도?");
			}
		});
	}

	loadUsers();

	$(document).on("click", ".item", function() {
		let id = $(this).attr("user");
		console.log(id)

		$.ajax({
			type : "get",
			url : "${root}user/" + id,
			success : function(result) {
				if (result.status) {
					$("#userid").val(result.data.userid);
					$("#pass").val(result.data.pass);
				}
			},
			error : function() {
				alert("잠시 서버 이상으로 사용자 목록 조회 실패. 잠시후 다시 시도?");
			}
		})
	})
	function formToJson() {
		let obj = {};
		let fields = $("#user>input");
		$.each(fields, function(idx, field) {
			obj[field.id] = field.value;
		});
		return JSON.stringify(obj);
	}
</script>
</html>
