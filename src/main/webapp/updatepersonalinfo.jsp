<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<title>회원정보 수정</title>
</head>
<body>
	<div class="ex">
		<h2>회원정보 수정</h2>
		<form class="form-horizontal" role="form" method="post"
			action="<c:url value='/user.do/updatemem'/>">
			<input type="hidden" name="id" value="/${currentId }" />
			<input type="hidden" name="mname" value="${mem.mname }" />
			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" id="password" name="password"
						name="excludeHangul" data-rule-required="true"
						placeholder="변경하실 비밀번호를 입력해주세요" maxlength="30" style="width:200px;" >
				</div>
				
				
			</div>
			<div class="form-group" id="divrePassword">
			<label for="inputPassword" class="col-lg-2 control-label">패스워드 재입력</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" id="repassword" name="repassword"
						name="excludeHangul" data-rule-required="true"
						placeholder="다시한번 비밀번호를 입력해주세요" maxlength="30" style="width:200px;">
				</div>
		
			
			</div>
			<div class="form-group" id="divAddress">
				<label for="inputAddress" class="col-lg-2 control-label">주소</label>
				<div class="col-lg-10">
					<input type="text" class="form-control" id="addr" name="addr"
						data-rule-required="true" placeholder="변경하실 주소를 입력해주세요" maxlength="50" style="width:500px;">
				</div>
			</div>
			<div class="form-group" id="divPhoneNumber">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">전화번호</label>
				<div class="col-lg-10">
					<input type="tel" class="form-control onlyNumber" id="tel" name="tel"
						data-rule-required="true" placeholder="변경하실 전화번호를 입력해주세요."
						maxlength="11" style="width:300px;">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-info">등록</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>