<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mystyle.css'/>">

</head>
<body>
	<div class="ex">
		<h2>회원가입</h2>
		<form class="form-horizontal" role="form" method="post"
			action="<c:url value='/user.do/signup'/>">
			<input type="hidden" name="action" value="signup" />
			<div class="form-group" id="divId">
				<label for="inputId" class="col-lg-2 control-label">아이디</label>
				<div class="col-lg-10">
					<input type="email" class="form-control onlyAlphabetAndNumber"
						id="id" name="id" data-rule-required="true" placeholder="" maxlength="30">
				</div>
			</div>

			<div class="form-group" id="divPassword">
				<label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
				<div class="col-lg-10">
					<input type="password" class="form-control" id="password"
						name="password" data-rule-required="true"
						placeholder="영문 숫자포함  6자리 이상" maxlength="30">
				</div>
			</div>
			<div class="form-group" id="divName">
				<label for="inputName" class="col-lg-2 control-label">이름</label>
				<div class="col-lg-10">
					<input type="text" class="form-control onlyHangul" id="mname" name="mname"
						data-rule-required="true" placeholder="이름" maxlength="15">
				</div>
			</div>
			<div class="form-group" id="divAddress">
				<label for="inputAddress" class="col-lg-2 control-label">주소</label>
				<div class="col-lg-10">
					<input type="text" class="form-control" id="addr" name="addr"
						data-rule-required="true" placeholder="주소" maxlength="50">
				</div>
			</div>
			<div class="form-group" id="divPhoneNumber">
				<label for="inputPhoneNumber" class="col-lg-2 control-label">전화번호</label>
				<div class="col-lg-10">
					<input type="tel" class="form-control onlyNumber" id="tel" name="tel"
						data-rule-required="true" placeholder="010-xxx-xxxx"
						maxlength="11">
				</div>
			</div>
			<div class="form-group" id="divAllergy">
				<label for="inputAllergy" class="col-lg-2 control-label">알레르기</label>
				<div class="col-lg-10">
					<fieldset>
						<legend>check</legend>
						<label class="checkbox-inline"><input type="checkbox" name="allergy"
							value="대두">대두</label> <label class="checkbox-inline"><input
							type="checkbox" name="allergy" value="땅콩">땅콩</label> <label
							class="checkbox-inline"><input type="checkbox" name="allergy" value="우유">우유</label>
						<label class="checkbox-inline"><input type="checkbox" name="allergy"
							value="게">게</label> <br> <label class="checkbox-inline"><input
							type="checkbox" name="allergy" value="새우">새우</label> <label
							class="checkbox-inline"><input type="checkbox" name="allergy" value="참치">참치</label>
						<label class="checkbox-inline"><input type="checkbox" name="allergy"
							value="년어">연어</label> <label class="checkbox-inline"><input
							type="checkbox" name="allergy" value="쑥">쑥</label> <br> <label
							class="checkbox-inline"><input type="checkbox" name="allergy"
							value="소고기">소고기</label> <label class="checkbox-inline"><input
							type="checkbox" name="allergy" value="닭고기">닭고기</label> <label
							class="checkbox-inline"><input type="checkbox" name="allergy"
							value="돼지고기">돼지고기</label> <br> <label
							class="checkbox-inline"><input type="checkbox" name="allergy"
							value="복숭아">복숭아</label> <label class="checkbox-inline"><input
							type="checkbox" name="allergy" value="민들레">민들레</label> <label
							class="checkbox-inline"><input type="checkbox" name="allergy"
							value="계란흰자">계란흰자</label>

					</fieldset>

				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<button type="submit" class="btn btn-primary">등록</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>