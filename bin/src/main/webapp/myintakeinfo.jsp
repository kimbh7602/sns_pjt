<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.boot.dto.FoodVo, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>섭취 상품 정보</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.bundle.min.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.js"></script>
<script src = "https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mystyle.css'/>">
<script type="text/javascript">
	$(document).ready(function(){
		var data = {
				datasets : [ {
					backgroundColor : [ 'rgba(100, 0, 0, 0.25)',
							'rgba(0, 100, 0, 0.25)',
							'rgba(0, 0, 100, 0.25)',
							'rgba(100, 100, 0, 0.25)',
							'rgba(0, 100, 100, 0.25)',
							'rgba(100, 0, 100, 0.25)',
							'rgba(100, 100, 100, 0.25)',
							'rgba(0, 0, 0, 0.25)',
							'rgba(200, 100, 250, 0.25)' ],
					data : [${sum.carbo}, ${sum.protein}, ${sum.fat}, ${sum.sugar},
							${sum.natrium}, ${sum.chole}, ${sum.fattyacid}, ${sum.transfat} ]
				} ],

				labels : [ '탄수화물', '단백질', '지방', '당류', '나트륨',
						'콜레스테롤', '포화 지방산', '트렌스지방' ]
			};
			var myDoughnutChart = new Chart($("#myChart"), {
				type : 'horizontalBar',
				data : data
			//						 		    options: options
			});
		
		$('#selection').on('change', function(){
			$(location).attr('href', 'food.do?action=#');
		})
	});
	
</script>
</head>
<body>
<div class="container">
	<jsp:include page="/nav.jsp"></jsp:include>
	<div class="row">
		<h1 align="center">총 섭취 데이터</h1>
		<canvas id="myChart" class="col-xs-12 col-sm-4 col-md-3"></canvas>
			<div class="col-xs-12"
				style="text-align: right; margin-bottom: 15px;">
				<form action="<c:url value='/intake.do/searchintake'/>" class="form-inline">
					<input type="hidden" name="action" value="searchintake"/>
					<div class="form-group">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="keyword" placeholder="상품 이름을 입력하세요.">
					</div>
					<button type="submit" class="btn btn-info">검색</button>
				</form>
			</div>
		</div>
		

		<div class="panel panel-info">
			<div class="panel-heading">나의 섭취 리스트</div>
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
							<span style="float: right;"><label>섭취 날짜</label> ${item.idate }&nbsp;&nbsp;&nbsp;<label>섭취 수량</label>&nbsp;&nbsp;&nbsp; ${item.icount }</span>
							</h3>
							<hr>
							<p>${item.material}</p>
							<div class="btn-group" role="group">
							<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i class="glyphicon glyphicon-tag"></i> 삭제</a>
							<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i class="glyphicon glyphicon-tag"></i> 찜</a>
							</div>
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