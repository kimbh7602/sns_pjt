<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 사항</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#selectSort').change(function() {
			var value = $(this).val();
		 if(value=="sortView"){
				$(location).attr("href","<c:url value='/notice.do/sortView'/>")
			}else if(value=="sortRecent"){
				$(location).attr("href","<c:url value='/notice.do/sortrecent'/>")
			}else if(value=="sortRegist"){
				$(location).attr("href","<c:url value='/notice.do/sortRegist'/>")
			}
		});
	})
</script>

</head>
<body>
	<div class="container">
		<jsp:include page="/nav.jsp"></jsp:include>
		<h1 style="text-align: center; font-size: 3em; margin-bottom:">공지
			게시판</h1>
		<hr style="margin-bottom: 40px;">

		<div>

			<select name="selectSort" id="selectSort"
				style="float: right; margin: -30px auto;">
				<c:choose>
				<c:when test="${sel == null }">
				<option value="sortRegist">등록순</option>
				<option value="sortView">조회수순</option>
				<option value="sortRecent">최신순</option>
				</c:when>
				<c:when test="${sel == 'reg' }">
				<option value="sortRegist" selected="selected">등록순</option>
				<option value="sortView">조회수순</option>
				<option value="sortRecent">최신순</option>
				</c:when>
				<c:when test="${sel == 'view' }">
				<option value="sortRegist">등록순</option>
				<option value="sortView" selected="selected">조회수순</option>
				<option value="sortRecent">최신순</option>
				</c:when>
				<c:when test="${sel == 'recent' }">
				<option value="sortRegist">등록순</option>
				<option value="sortView">조회수순</option>
				<option value="sortRecent" selected="selected">최신순</option>
				</c:when>
				</c:choose>
			</select>

		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td><a href="<c:url value='/notice.do/infoNotice/${item.nid }'/>">${item.ntitle }</a>
								</td>
								<td>${item.ncount }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="row">
					<div class="col-sm-12 text-right">
					<c:if test="${currentId == 'admin@admin.com' }">
						<a href="<c:url value='/notice_insert.jsp'/>" class="btn btn-info btn-flat">글쓰기</a>
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