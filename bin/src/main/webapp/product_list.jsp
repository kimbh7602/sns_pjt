<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<c:forEach var="item" items="${list}">
		<div class="row productRow">
			<div class="col-xs-12 col-sm-4 col-md-3" style="max-height: 250px;">
				<img class="media-object" src="<c:url value='/${item.img}'/>" alt="${item.name}"
					width="200">
				<div class="custom_tooltip"
					style="position: absolute; width: 200px; background: #696969a8; bottom: 0; color: white; padding: 10px; vertical-align: middle; text-align: center; display: none;">
					<p>${item.name}</p>
					<p style="margin-bottom: 0">
						<strong> </strong>
					</p>
				</div>
			</div>
			<div class="col-xs-12 col-sm-8 col-md-9">
				<h3>
					<a class="productName"
						href="<c:url value='/food.do/infofood/${item.code }'/>">${item.name}</a>
				</h3>
				<hr>
				<p>${item.material}</p>
				<div class="btn-group" role="group">
					<a href="#" class="btn btn-flat btn-sm btn-info" role="button"><i
						class="glyphicon glyphicon-tag"></i> 추가</a> <a href="#"
						class="btn btn-flat btn-sm btn-info" role="button"><i
						class="glyphicon glyphicon-tag"></i> 찜</a>
				</div>
			</div>
		</div>
	</c:forEach>

</html>