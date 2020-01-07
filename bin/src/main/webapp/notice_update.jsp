<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항 수정</title>
</head>
<body>
	<jsp:include page="/nav.jsp"></jsp:include>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지
			게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-info">
			<div class="panel-heading">
				<strong>${notice.ntitle }</strong>
			</div>
			<div class="panel-body">
			<form action="<c:url value='/notice.do/updateNotice'/>" method="post">
					<div class="form-group">
						<label for="title">제목</label>
						<input type="hidden" name="nid" value="${notice.nid }" />
						<input id="title" name="ntitle" type="text" class="form-control" value="${notice.ntitle }">
					</div>
					<div class="form-group">
						<label for="ncontent">내용</label>
						<textarea id="ncontent" name="ncontent" class="form-control" rows="15">${notice.ncontent }</textarea>
					</div>
					
					<div class="row">
						<div class="col-sm-12 text-right">
							<button type="submit" class="btn btn-info btn-flat">수정</button>
						</div>
					</div>
				</form>
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