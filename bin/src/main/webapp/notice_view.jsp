<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
</head>
<body>
	<jsp:include page="/nav.jsp"></jsp:include>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지
			게시판</h1>
		<hr style="margin-bottom: 40px;">
		<form id="noticeForm" action="<c:url value='/notice.do/updateview'/>" method="post">
		<div class="panel panel-info">
			<div class="panel-heading">
				<strong>${notice.ntitle }</strong>
				<input type="hidden" name="nid" value="${notice.nid }" />
				<input type="hidden" name="ntitle" value="${notice.ntitle }" />
			</div>
			<div class="panel-body">
				${notice.ncontent }
				<input type="hidden" name="ncontent" value="${notice.ncontent }" />
			</div>
			<div class="panel-footer text-right">
				<c:if test="${currentId == 'admin@admin.com' }">
				<a href="<c:url value='/notice.do/updateview/${notice.nid }'/>" class="btn btn-info btn-flat">수정</a>
				<a href="<c:url value='/notice.do/deletenotice/${notice.nid }'/>" class="btn btn-danger btn-flat">삭제</a>
				</c:if>
				<a href="<c:url value='/notice.do/listNotice'/>" class="btn btn-primary btn-flat">목록</a>
			</div>
		</div>
		</form>
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