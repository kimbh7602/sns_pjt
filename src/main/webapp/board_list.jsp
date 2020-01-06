<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>질문 게시판</title>
</head>
<body>
<div class="container">
	<jsp:include page="/nav.jsp"></jsp:include>
	<h1 style="text-align: center; font-size: 3em; margin-bottom:">질문 게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr>
							<td>${status.count }</td>
							<td>
								<a href="<c:url value='/board.do/infoboard/${item.bid }'/>">${item.btitle }</a>
							</td>
							<td>${item.user_id }</td>
							<td>${item.bcount }</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-sm-12 text-right">
						<c:if test="${currentId != null }">
						<a href="<c:url value='/board_insert.jsp'/>" class="btn btn-info btn-flat">글쓰기</a>
						</c:if>
					</div>
				</div>
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