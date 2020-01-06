<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.ssafy.boot.dto.FoodVo, java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 상세 정보</title>

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

<script>
	$(document).ready(function() {
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
					data : [${food.carbo}, ${food.protein}, ${food.fat}, ${food.sugar},
							${food.natrium}, ${food.chole}, ${food.fattyacid}, ${food.transfat} ]
				} ],

				labels : [ '탄수화물', '단백질', '지방', '당류', '나트륨',
						'콜레스테롤', '포화 지방산', '트렌스지방' ]
			};
			var myDoughnutChart = new Chart($("#myChart"), {
				type : 'doughnut',
				data : data
			//						 		    options: options
			});
			
			$('#insertintake').on('click', function(){
				$.ajax({
					type : "post",
					url : "<c:url value='/intake.do/insertintake/" + ${food.code} + "'/>",
					dataType : "text",
					success : sFunc,
					error : eFunc
				});
				
				function sFunc(data) {
					alert(data);
				};
				
				function eFunc(e){
					console.log(e)
					alert(e);
				};
			});
	})
</script>
</head>
<body>
<div class="container">
	<jsp:include page="/nav.jsp"></jsp:include>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">식품 상세 정보</h1>
		<hr style="margin-bottom: 40px;">

		<div class="row productRow">
			<div class="col-xs-12 col-sm-5 col-md-4 col-lg-3">
				<img id="product_img" class="media-object" src="<c:url value='/${food.img }'/>" alt="" width="250"
					style="margin: 0 auto;">
			</div>

			<div class="col-xs-12 col-sm-7 col-md-8 col-lg-9">
				<table class="table table-hover">
					<tr>
						<th>제품명</th>
						<td id="product_name">${food.name }</td>
					</tr>
					<tr>
						<th>제조사</th>
						<td id="product_maker">${food.maker }</td>
					</tr>
					<tr>
						<th>원재료</th>
						<td>
							<p id="product_material">${food.material }</p>
						</td>
					</tr>
				</table>

				<div class="input-group">
					<span class="input-group-addon" id="basic-addon1">검색 빈도수</span> <input
						type="text" class="form-control" placeholder="${food.searchCount }">
					<span class="input-group-btn"> <a href="#" id="insertintake"
						class="btn btn-flat btn-info" role="button"> <i
							class="glyphicon glyphicon-tag"></i> 추가
					</a> <a href="#" class="btn btn-flat btn-info" role="button"> <i
							class="glyphicon glyphicon-tag"></i> 찜
					</a>
					</span>
				</div>
				<div class="btn-group" role="group"></div>
			</div>
		</div>
	
	
<h1 style="text-align: center; font-size: 3em;">영양 정보</h1>

		<hr style="margin-bottom: 40px;">
		<div class="row">
			<div class="col-sm-8">
				<canvas id="myChart" style="max-height: 600px; max-width: 600px;"></canvas>
			</div>

			<div class="col-sm-4">
				<table class="table">
					<tr>
						<td>일일 제공량</td>
						<td id="SERVING_WT">${food.supportpereat }</td>
					</tr>

					<tr>
						<td>칼로리</td>
						<td id="NUTR_CONT1">${food.calory }</td>
					</tr>

					<tr>
						<td>탄수화물</td>
						<td id="NUTR_CONT2">${food.carbo }</td>
					</tr>

					<tr>
						<td>단백질</td>
						<td id="NUTR_CONT3">${food.protein }</td>
					</tr>

					<tr>
						<td>지방</td>
						<td id="NUTR_CONT4">${food.fat }</td>
					</tr>

					<tr>
						<td>당류</td>
						<td id="NUTR_CONT5">${food.sugar }</td>
					</tr>

					<tr>
						<td>나트륨</td>
						<td id="NUTR_CONT6">${food.natrium }</td>
					</tr>

					<tr>
						<td>콜레스테롤</td>
						<td id="NUTR_CONT7">${food.chole }</td>
					</tr>

					<tr>
						<td>포화 지방산</td>
						<td id="NUTR_CONT8">${food.fattyacid }</td>
					</tr>

					<tr>
						<td>트렌스지방</td>
						<td id="NUTR_CONT9">${food.transfat }</td>
					</tr>
				</table>
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