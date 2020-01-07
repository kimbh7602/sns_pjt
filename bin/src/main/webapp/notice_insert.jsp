<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 작성</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


</head>
<body>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지 게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-default">
			<div class="panel-body">
			<div class="boody">
				<form action="<c:url value='/notice.do/registerNotice'/>" method="post">
					<div class="form-group" id="title">
						<label for="title">제목</label>
						<input id="title" name="ntitle" type="text" class="form-control" placeholder="제목을 입력해주세요." >
					</div>
					<div class="form-group">
						<label for="ncontent">내용</label>
						<input id="ncontent" name="ncontent" type="text" class="form-control"  style="height:500px;" placeholder="내용을 입력해주세요.">
					</div>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<button type="submit" class="btn btn-info btn-flat" style="float:right">글쓰기</button>
						</div>
						
					</div>
				</form>
			</div>
			</div>
		</div>
</body>
</html>