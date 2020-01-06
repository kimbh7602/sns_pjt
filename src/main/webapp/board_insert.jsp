<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>질문 작성</title>
</head>
<body>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">질문
			게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-default">
			<div class="panel-body">
				<form action="<c:url value='/board.do/registerboard'/>" method="post">
					<input type="hidden" name="user_id" value="${currentId }" />
					<div class="form-group">
						<label for="title">제목</label>
						<input id="btitle" name="btitle" type="text" class="form-control" placeholder="제목을 입력해주세요." >
					</div>
					<div class="form-group">
						<label for="ncontent">내용</label>
						<textarea id="bcontent" name="bcontent" class="form-control" rows="15" placeholder="내용을 입력해주세요."></textarea>
					</div>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<button type="submit" class="btn btn-info btn-flat">글쓰기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>