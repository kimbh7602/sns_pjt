<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.boot.dto.FoodVo, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 정보</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#searchbtn').on('click', function(){
			var keyword = $('#keyword').val();
			var selection = $('#selection').val();
			$(location).attr('href', '<c:url value="/food.do/searchfood/'+keyword+'/'+selection+'"/>');
		});
		
		$('#selection').on('change', function(){
			var value = $(this).val();
			if(value == 'name'){
				$(location).attr('href', '<c:url value="/food.do/listbyname"/>');
			}else if(value == 'maker'){
				$(location).attr('href', '<c:url value="/food.do/listbymaker"/>');
			}
		});
		
		$('#keyword').on('keyup', function(){
			var keyword = $(this).val();
			console.log(keyword);
			if(keyword != null){
				var value = $('#selection').val();
				if(value == 'name'){
					var url = '<c:url value="/food.do/searchfoodbykeyword/'+keyword+'/'+value+'"/>';
					$.ajax({
						type : "post",
						url : url,
						dataType : "html",
						success : sFunc,
						error : eFunc
					});
					
					function sFunc(data) {
						$('.productPanel').html(data);
					};
					
					function eFunc(e){
						console.log(e)
					};
				}else if(value == 'maker'){
					var url = '<c:url value="/food.do/searchfoodbykeyword/'+keyword+'/'+value+'"/>';
					$.ajax({
						type : "post",
						url : url,
						dataType : "html",
						success : sFunc,
						error : eFunc
					});
					
					function sFunc(data) {
						$('.productPanel').html(data);
					};
					
					function eFunc(e){
						console.log(e)
					};
				}
			}else{
				$('.productPanel').html("");
			}
			/* else{
				var url = ''
				$.ajax({
					type : "post",
					url : url,
					dataType : "html",
					success : sFunc,
					error : eFunc
				});
				
				function sFunc(data) {
					$('.productPanel').html(data);
				};
				
				function eFunc(e){
					console.log(e)
				};
			} */
		});
		
	})
</script>
</head>
<body>
<div class="container">
	<jsp:include page="/nav.jsp"></jsp:include>
	<div class="row">
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;">
				<form id="searchForm" action="<c:url value='/food.do/searchfood'/>" class="form-inline">
					<input type="hidden" name="action" value="searchfood"/>
					<div class="form-group">
						<select id="selection" name="selection" class="form-control">
							<c:choose>
								<c:when test="${sel == 'name' }">
									<option value="name" selected="selected">상품명</option>
									<option value="maker">제조사</option>
									<option value="material">재료명</option>
								</c:when>
								<c:when test="${sel == 'maker' }">
									<option value="name">상품명</option>
									<option value="maker" selected="selected">제조사</option>
									<option value="material">재료명</option>
								</c:when>
								<c:when test="${sel == null }">
									<option value="name">상품명</option>
									<option value="maker">제조사</option>
									<option value="material">재료명</option>
								</c:when>
							</c:choose>
						</select>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="keyword" name="keyword" placeholder="검색어를 입력하세요.">
					</div>
					<button id="searchbtn" type="button" class="btn btn-info">검색</button>
				</form>
			</div>
		</div>

		<div class="panel panel-info">
			<div class="panel-heading">제품 리스트</div>
			<div class="panel-body productPanel">
			<!-- 아이템 영역 -->
			<c:forEach var="item" items="${list}" >
				<div class="row productRow">
					<div class="col-xs-12 col-sm-4 col-md-3" style="max-height: 250px;">
						<img class="media-object" src="<c:url value='/${item.img}'/>" alt="${item.name}" width="200">
							<div class="custom_tooltip" style="position: absolute; width: 200px; background: #696969a8; bottom: 0; color: white; padding: 10px; vertical-align: middle; text-align: center; display: none;">
							<p>${item.name}</p>
							<p style="margin-bottom: 0"><strong>
							</strong></p>
							</div>
							</div>
							<div class="col-xs-12 col-sm-8 col-md-9">
							<h3>
							<a class="productName" href="<c:url value='/food.do/infofood/${item.code }'/>">${item.name}</a>
							</h3>
							<hr>
							<p>${item.material}</p>
					</div>
				</div>
			</c:forEach>
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
</div>
</body>
</html>