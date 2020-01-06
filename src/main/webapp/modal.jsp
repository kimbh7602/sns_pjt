<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="row productRow">
		<div class="col-xs-12 col-sm-5 col-md-5 col-lg-5">
			<img id="product_img" class="media-object" src="${recommend.img }"
				alt="" width="250" style="margin: 0 auto;">
		</div>
		<input id="code" type="hidden" name="code" value="${recommend.code }" />

		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">
			<table class="table table-hover">
				<tr>
					<th>제품명</th>
					<td id="name">${recommend.name }</td>
				</tr>
				<tr>
					<th>제조사</th>
					<td id="maker">${recommend.maker }</td>
				</tr>
				<tr>
					<th>원재료</th>
					<td>
						<p id="material">${recommend.material }</p>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>