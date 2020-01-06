<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>

<!-- <script
	src="https://ajax.googleapis.com/aj	ax/libs/jquery/1.12.4/jquery.min.js"></script>
합쳐지고 최소화된 최신 CSS
<link rel="stylesheet" href="js/bootstrap.js">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
부가적인 테마
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
합쳐지고 최소화된 최신 자바스크립트
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css"> -->
</head>
<script type="text/javascript">
	function check() {
		var id = pid.value;
		var pw = ppw.value;
		var name = pname.value;
		var addr = paddr.value;
		var tel = ptel.value;

		if (pw == "" || pw.length < 6) {
			alert("잘못된 비밀번호 입니다.");
			ppw.focus();
			return;
		}
		if (name == "") {
			alret("이름을 입력해주세요.");
			pname.focus();
			return;
		}
		if (addr == "") {
			alret("주소를 입력해주세요.");
			paddr.focus();
			return;
		}
		if (tel == "") {
			alret("전화번호를 입력해주세요.");
			ptel.focus();
			return;
		}
		rform.submit();
	}
</script>


<body>
	<jsp:include page="/nav.jsp"></jsp:include>
	<!--  <iframe src="mainMenu.jsp" width="100%" height="369px" scrolling="no"></iframe>-->
	<div style="width: 40%; margin: 0 auto">
		<div class="main hc-element-invisible"
			data-animation-effect="fadeInUpSmall" data-effect-delay="100">
			<div class="form-block p-30 light-gray-bg border-clear"
				style="width: 100%">
				<h2 class="title" style="width: 50%; margin: 0 auto">회원 정보 수정</h2>
				<br /> <br />
				<form class="form-horizontal" role="form" method="post" id="rform"
					action="<c:url value='/user.do/updatemem'/>">

					<div class="form-group has-feedback row">
						<label for="id"
							class="col-md-3 control-label text-md-right col-form-label">아이디
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="id" name="id"
								placeholder="" required name="id" readonly="readonly"
								value="${currentId}"><i
								class="fa fa-pencil form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="password"
							class="col-md-3 control-label text-md-right col-form-label">비밀번호
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="password" class="form-control" id="password"
								required name="password" value="${mam.password}"> <i
								class="fa fa-pencil form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="mname"
							class="col-md-3 control-label text-md-right col-form-label">이름
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="mname" name="mname"
								value="${mem.mname }"> <i
								class="fa fa-user form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="addr"
							class="col-md-3 control-label text-md-right col-form-label">주소
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="addr"
								placeholder="addr" required name="addr" value="${mem.addr }">
							<i class="fa fa-envelope form-control-feedback pr-4"></i>
						</div>
					</div>
					
					
					<div class="form-group has-feedback row">
						<label for="tel"
							class="col-md-3 control-label text-md-right col-form-label">전화번호
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="tel"
								placeholder="010-xxx-xxxx" required name="tel"
								value="${mem.tel }"> <i
								class="fa fa-lock form-control-feedback pr-4"></i>
						</div>
					</div>
					<div class="form-group has-feedback row">
						<label for="inputAllergie"
							class="col-md-3 control-label text-md-right col-form-label">알레르기
							<span class="text-danger small">*</span>
						</label>
						<div class="col-md-8">
							<fieldset class="form-group">
								<legend class="col-form-legend col-sm-3"> Check</legend>
								<div class="row">
									<div class="col-md-10">

										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='대두'
												type="checkbox" value="대두"> <label
												class="form-check-label">대두 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='땅콩'
												type="checkbox" value="땅콩"> <label
												class="form-check-label">땅콩 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='우유'
												type="checkbox" value="우유"> <label
												class="form-check-label">우유 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='게'
												type="checkbox" value="게"> <label
												class="form-check-label">게</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='새우'
												type="checkbox" value="새우"> <label
												class="form-check-label">새우</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='참치'
												type="checkbox" value="참치"> <label
												class="form-check-label">참치</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='연어'
												type="checkbox" value="연어"> <label
												class="form-check-label">연어</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='쑥'
												type="checkbox" value="쑥"> <label
												class="form-check-label">쑥 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='소고기'
												type="checkbox" value="소고기"> <label
												class="form-check-label">소고기</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='닭고기'
												type="checkbox" value="닭고기"> <label
												class="form-check-label">닭고기 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='돼지고기'
												type="checkbox" value="돼지고기"> <label
												class="form-check-label">돼지고기</label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='복숭아'
												type="checkbox" value="복숭아"> <label
												class="form-check-label">복숭아 </label>
										</div>
										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='민들레'
												type="checkbox" value="민들레"> <label
												class="form-check-label">민들레</label>
										</div>

										<div class="form-check form-check-inline col-md-4">
											<input name="allergy" class="form-check-input" id='계란흰자'
												type="checkbox" value="계란흰자"> <label
												class="form-check-label">계란흰자 </label>
										</div>
										<c:forTokens var="elem" items="${requestScope.mem.allergy }"
											delims=" ">
											<script>
												$("input:checkbox[id=${elem}]")
														.prop("checked", true);
											</script>

										</c:forTokens>

									</div>
								</div>
							</fieldset>
						</div>
					</div>
					<div class="form-group row" style="width: 50%; margin: 0 auto">
						<div class="ml-md-auto col-md-9">
							<input type="submit" value="수정"
								class="btn btn-group btn-default btn-animated"> 
								<input type="reset" value="취소"
								class="btn btn-group btn-default btn-animated">

							<!--  <i class="fa fa-check"></i>
						 -->
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- main end -->
		<br /> <br /> <br />
	</div>
	<footer style="background: #ececec; padding: 50px;">
		<h1>Find Us</h1>
		<hr>
		<p>
			<i class="glyphicon glyphicon-envelope"></i> (SSAFY) 서울시 강남구 테헤란로
			멀티스퀘어
		</p>
		<p>
			<i class="glyphicon glyphicon-envelope"></i> 1544-9001
		</p>
		<p>
			<i class="glyphicon glyphicon-envelope"></i> admin@ssafy.com
		</p>
	</footer>

</body>
</html>
