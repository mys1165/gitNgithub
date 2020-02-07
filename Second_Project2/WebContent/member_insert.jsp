<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div class="page-header">
    	<h1>회원 등록</h1>  
	</div>
	
	<form role="form" action="member_insert.do" method="post">
			<div class="row">
				<label class="col-xs-1" for="id">아이디</label>
				<div class="col-xs-4">
					<input required type="text" class="form-control" id="id" name="c_member_id" placeholder="아이디를 입력하세요"><span id="idmsg"></span>
				</div>
				
				<div class="col-xs-1">
					<button class="btn btn-danger">중복확인</button>
				</div>
			</div>
			<br>
			
			<div class="row">
				<label class="col-xs-1" for="pw">비밀번호</label>
				<div class="col-xs-5">
					<input required type="password" class="form-control" id="pw" name="c_member_password" placeholder="비밀번호를 입력하세요">
					<span id="pwmsg"></span>
				</div>
			</div>
			<br>
			
			<div class="row">
				<label class="col-xs-1" for="pwck">비밀번호확인</label>
				<div class="col-xs-5">
					<input required type="password" class="form-control" id="pwck" name="pwcheck" placeholder="비밀번호 확인">
					<span id="pwcheckmsg"></span>
				</div>
			</div>
			<br>
			
			<div class="row">
				<label class="col-xs-1" for="name">이름</label>
				<div class="col-xs-5">
					<input required type="text" class="form-control" id="name" name="c_member_name" placeholder="이름을 입력하세요">
				</div>
			</div>
			<br>
			
			<div class="row">
				<label class="col-xs-1" for="gender">성별</label>
				<div class="col-xs-5">
					<input type="radio" id="gender" name="c_member_gender" value="m" checked>남자
					<input type="radio" id="gender" name="c_member_gender" value="f">여자
				</div>
			</div>
			<br>
			
			<div class="row">
				<label class="col-xs-1" for="birth">생년월일</label>
				<div class="col-xs-5">
					<input required type="date" class="form-control" id="birth" name="c_member_birth">					
				</div>
			</div>
			<hr>

			<div class="row">
				<div class="col-xs-12">
					<button type="submit" class="btn btn-danger">회원등록</button>
				</div>
			</div>
		
	</form>
</div>

	<script type="text/javascript">
      $(document).ready(function() {
         var ckid = '0';

         $("button").click(function(event) {
            var ida = $("input[name='c_member_id']").val();

            $.ajax({
               type : 'get',
               url : 'checkid.do',
               data : {
                  id : ida
               },
               dataType : 'text',
               success : function(result) {
                  if (result == "1") {
                     $("#idmsg").text("사용 가능한 아이디 입니다.");
                     $("#idmsg").css("color", "blue");
                     ckid = 1;
                  } else if (result == "0") {
                     $("#idmsg").text("사용할 수 없는 아이디 입니다.");
                     $("#idmsg").css("color", "red");
                     ckid = 0;
                  }
                  event.preventDefault();
               }
            });
         });

         $("input[name='c_member_password']").change(function() {
            var pw = $("input[name='c_member_password']").val();
            var limit = /^[a-zA-Z0-9]{1,12}$/;

            if (!limit.test(pw)) {
               $("#pwmsg").text("12자 이하 대 소문자, 숫자를 사용하시오.");
               $("#pwmsg").css("color", "red");
            } else {
               $("#pwmsg").text("");
            }
         });

         $("input[name='pwcheck']").change(function() {
            var pw = $("input[name='c_member_password']").val();
            var pwcheck = $("input[name='pwcheck']").val();

            if (pw != pwcheck) {
               $("#pwcheckmsg").text("비밀번호가 일치하지 않습니다.");
               $("#pwcheckmsg").css("color", "red");
            } else {
               $("#pwcheckmsg").text("비밀번호가 일치합니다.");
               $("#pwcheckmsg").css("color", "blue");
            }
         });

         $("input[type='submit']").click(function(event) {
               if (ckid != 1) {
                  alert("아이디 중복 확인을 해주세요.");
                  event.preventDefault();
               }

         });
      });
	</script>
</body>
</html>