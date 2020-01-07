<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>섭취 정보</title>
<script>
	$(document).ready(function() {
		$.ajax({
			type : "get",
			url : "res/FoodInfo.xml",
			dataType : "xml",
			success : resXml,
			error : eXml
		});
	});

	function eXml(s) {
		console.log(s);
	}
	function resXml(data) {
		$(data)
				.find('food')
				.each(
						function(ret) {
							var code = $("code", this).text();
							var name = $("name", this).text();
							var maker = $("maker", this).text();
							var material = $("material", this).text();
							var image = $("image", this).text();

							var product = '<div class="col-sm-6 col-md-6">';
							product += '<div class="thumbnail">';
							product += '<img src="' + image + '" alt="' + name
									+ '" style="max-width: 50%;">';
							product += '<div class="caption">';
							product += '<h3>' + name + '</h3>';
							product += '<p class="small material">' + material
									+ '</p>';
							product += '<div class="btn-group btn-group-justified" role="group">';
							product += '<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i class="glyphicon glyphicon-tag"></i> 추가</a>';
							product += '<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i class="glyphicon glyphicon-tag"></i> 찜</a>';
							product += '</div>';
							product += '</div>';
							product += '</div>';
							product += '</div>';

							$(".productRow").append(product);
						});
	}
</script>
</head>
<body>
	<div class="panel panel-info">
			<div class="panel-heading">제품 리스트</div>
			<div class="panel-body">
				<div class="row productRow"></div>
			</div>
		</div>
</body>
</html>