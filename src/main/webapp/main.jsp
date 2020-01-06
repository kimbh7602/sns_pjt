<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('.caption').on("mouseover", function(){
			$(this).css('opacity','1');
		});
		$('.caption').on("mouseleave", function(){
			$(this).css('opacity','0');
		});
	})
</script>

<title>메인 페이지</title>

</head>

<body>
	<div class="container">
		<jsp:include page="nav.jsp"></jsp:include>
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="row productRow">
				<c:forEach items="${list }" var="item">
					<form action="<c:url value='/food.do/infofood/${item.code }' />" method="post">
						<input type="hidden" name="code" value="${item.code }" />
						<div class="col-sm-6 col-md-4">
						<div class="thumbnail" style="border:none;">
						<div class="overlay">
						<p class="text">${item.name }</p>
						</div>
						<img src="<c:url value='/${item.img }' />" alt="${item.name }">
						<div class="caption text-center" style="opacity:0;">
						<button type="submit" class="btn btn-lg btn-block btn-primary">상품 정보로 이동 &nbsp;<i class="glyphicon glyphicon-arrow-right"></i></button>
						</div>
						</div>
						</div>
					</form>
				</c:forEach>
				</div>
			</div>
		</div>
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