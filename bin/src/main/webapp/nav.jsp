<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mystyle.css' />">
<script type="text/javascript">
$(document).ready(function(){
	$('#modalbtn').on('click', function(){
		$.ajax({
			type : "post",
			url : "<c:url value='/food.do/recommendfood'/>",
			dataType : "html",
			success : sFunc,
			error : eFunc
		});
		
		function sFunc(data) {
			$('.modal-body').html(data);
			var src = $('#product_img').attr('src');
			src = "<c:url value='/" + src + "'/>";
			$('#product_img').attr('src', src);
			var action = $('#modalForm').attr('action');
			var code = $('#code').val();
			action = action + "/" + code;
			$('#modalForm').attr('action', action);
			$('#recommendModal').modal();
		};
		
		function eFunc(e){
			console.log(e)
		};
	});
	
	
})
</script>
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="<c:url value='/food.do/mainfood'/>" style="padding: 5px;">
						<img alt="Brand" src="<c:url value='/img/ssafy_logo.png' />"
						style="max-height: 40px;">
					</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="<c:url value='/notice.do/listNotice'/>">공지 사항 <span
								class="sr-only">(current)</span></a></li>
						<!-- 
						<li class="dropdown" id="menuFood"><a
									class="btn btn-sm dropdown-toggle" href="#"
									data-toggle="dropdown" id="navFood"><span>&nbsp;상품</span>
								</a>
									<div class="dropdown-menu" id="dropdownFood" >
										<ul>
											<li><a href="food.do/listfood" >상품 정보</a></li>
											<li><a href="#" >상품 입력</a></li>
										</ul>
									</div>
						</li>
						 -->
						
						<li>
						<a href="<c:url value='/food.do/listfood' />">상품 정보</a></li>
						<c:if test="${currentId != null }">
						<li><a href="<c:url value='/intake.do/selectallintake' />">섭취 상품 정보</a></li>
						</c:if>
						<li><a href="<c:url value='/board.do/listboard' />">게시판</a></li>
						<li><a href="<c:url value='/recipeboard/registerboard' />">레시피게시판</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${currentId == null }">
							<li><a class="btn btn-sm" href="<c:url value='/user.do/signUpPage'/>"> <span
								class="glyphicon glyphicon-user" aria-hidden="true"></span> <span>&nbsp;Sign
									Up</span>
						</a></li>
						<li>
							<ul class="nav navbar-nav pull-right">
								<li class="dropdown" id="menuLogin"><a
									class="btn btn-sm dropdown-toggle" href="#"
									data-toggle="dropdown" id="navLogin"> <span
										class="glyphicon glyphicon-lock" aria-hidden="true"></span> <span>&nbsp;Login</span>
								</a>
									<div class="dropdown-menu" style="padding: 17px;">
										<form action="<c:url value='/user.do/loginmem' />">
											<!-- <input type="hidden" name="action" value="loginmem" /> -->
											<div class="form-group">
												<label for="id">아이디</label> <input type="email" name="id"
													class="form-control" id="id" placeholder="Email">
											</div>
											<div class="form-group">
												<label for="pw">패스워드</label> <input type="password" name="password"
													class="form-control" id="pw" placeholder="Password">
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-block btn-primary">로그인</button>
											</div>
										</form>
										<a href="<c:url value='/findPassword.jsp'/>" class="btn btn-block btn-warning">비밀번호 찾기</a> 
											<a href="<c:url value='/updatepersonalinfo.jsp'/>"
											class="btn btn-block btn-info">회원정보 수정 </a> <a
											href= "#"class="btn btn-block btn-danger">회원정보
											삭제 </a>
									</div></li>
							</ul>
						</li>
							</c:when>
							<c:when test="${currentId != null }">
							<li>
								<a id="modalbtn" class="btn btn-sm"> <span
								class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span> <span>&nbsp;오늘 뭐먹지?</span>
								</a>
							</li>
							<li><a class="btn btn-sm" href="<c:url value='/user.do/infomem?currentId=${currentId }' />"> <span
								class="glyphicon glyphicon-user" aria-hidden="true"></span> <span>&nbsp;ID : ${currentId }</span>
						</a></li>
							<li><a class="btn btn-sm" href="<c:url value='/user.do/logoutmem'/>"> <span
								class="glyphicon glyphicon-off" aria-hidden="true"></span> <span>&nbsp;Log Out</span>
						</a></li>
							</c:when>
						</c:choose>
						
					</ul>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<div class="modal fade" id="recommendModal" tabindex="-1" role="dialog" aria-labelledby="recommendModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">추천 음식</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <form id="modalForm" action="<c:url value='/food.do/infofood'/>" method="post">
		      <div class="modal-body">
		       	
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
		        <button type="submit" class="btn btn-primary">상품 정보</button>
		      </div>
		      </form>
		    </div>
		  </div>
		</div>

		<div class="jumbotron">
			<h1>
				WHAT WE <strong style="color: #4d7d5a;">PROVIDE</strong>
			</h1>
			<hr>
			<p>건강한 삶을 위한 먹거리 프로젝트</p>
		</div>

		<!-- <div class="panel panel-default">
			<div class="panel-body">
				<div class="row productRow"></div>
			</div>
		</div> -->
	</div>
	
	<%-- <% 
		String view = (String)request.getAttribute("view"); 
	%>
	<c:set var="view" scope="request" value="view"/>
	${view }
	<c:choose>
		<c:when test='${view eq "findpwview" }'>
			<jsp:include page="findPassword.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "signupview" }'>
			<jsp:include page="signUp.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "infomemview" }'>
			<jsp:include page="updatepersonalinfo.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "productinfoview" }'>
			<jsp:include page="productinfo.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "productdetailview" }'>
			<jsp:include page="productdetail.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "notice_listview" }'>
			<jsp:include page="notice_list.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "notice_viewview" }'>
			<jsp:include page="notice_view.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "notice_insertview" }'>
			<jsp:include page="notice_insert.jsp"></jsp:include>
		</c:when>
		<c:when test='${view eq "bestintakeinfoview" }'>
			<jsp:include page="bestintakeinfo.jsp"></jsp:include>
		</c:when>
	</c:choose> --%>
	

	<!-- <footer style="background: #ececec; padding: 50px;">
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
	</footer> -->
</body>
</html>