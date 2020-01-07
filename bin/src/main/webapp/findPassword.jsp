<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<title>비밀번호 찾기</title>
</head>
<body>
	<div class="ex">
		<h2>비밀번호 찾기</h2>
		<form class="form-horizontal" role="form" method="post"
			action="javascript:alert( 'success!' );">
			
		<div class="form-group_findpw" id="divName">
				<label for="inputName" class="col-lg-2 control-label">이름</label>
				<div class="col-lg-10">
					<input type="text" class="form-control onlyHangul" id="mname" name="mname"
						data-rule-required="true" placeholder="이름" maxlength="15" style="width:100px;">
				</div>
			</div>
			<div class="form-group" id="divId">
				<label for="inputId" class="col-lg-2 control-label">아이디</label>
				<div class="col-lg-10">
					<input type="text" class="form-control onlyAlphabetAndNumber" name="id"
						id="id" data-rule-required="true" placeholder="xxxxx@xxx.com" maxlength="30" style="width:200px;">
				</div>
			</div>
			
			<div class="form-group" id="divPhoneNumber">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">전화번호</label>
				<div class="col-lg-10">
					<input type="tel" class="form-control onlyNumber" id="tel" name="tel"
						data-rule-required="true" placeholder="010-xxx-xxxx" style="width:200px;"
						maxlength="11">
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-warning">확인</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>