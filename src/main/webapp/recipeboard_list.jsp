<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" />
<title>Example</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
</head>
<style>
/* Space out content a bit */
body {
  padding-top: 20px;
  padding-bottom: 20px;
}
/* Everything but the jumbotron gets side spacing for mobile first views */
.header, .marketing, .footer {
  padding-right: 15px;
  padding-left: 15px;
}
/* Custom page header */
.header {
  padding-bottom: 20px;
  border-bottom: 1px solid #e5e5e5;
}
/* Make the masthead heading the same height as the navigation */
.header h3 {
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}
/* Custom page footer */
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #e5e5e5;
}
/* Customize container */
@media ( min-width : 768px) {
  .container {
    max-width: 900px;
  }
}
.container-narrow>hr {
  margin: 30px 0;
}
/* Main marketing message and sign up button */
.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}
/* Supporting marketing content */
.marketing {
  margin: 40px 0;
}
.marketing p+h4 {
  margin-top: 28px;
}
/* Responsive: Portrait tablets and up */
@media screen and (min-width: 768px) {
  /* Remove the padding we set earlier */
  .header, .marketing, .footer {
    padding-right: 0;
    padding-left: 0;
  }
  /* Space out the masthead */
  .header {
    margin-bottom: 30px;
  }
  /* Remove the bottom border on the jumbotron for visual effect */
  .jumbotron {
    border-bottom: 0;
  }
}
</style>
<body>
  <div class="container">
    <div class="row marketing">
      <div class="col-lg-12">
        <table class="table">
          <thead>
            <tr>
              <td>No.</td>
              <td>title</td>
  
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${list}" var="i">
              <tr>
                <td>${i.rbid}</td>
                <td><a href="/article/${i.rbid}">${i.rbtitle}</a></td>
               
              </tr>
            </c:forEach>
            
          </tbody>
        </table>
      </div>
      	<a href="<c:url value='/recipeboard_insert.jsp'/>" class="btn btn-info btn-flat">글쓰기</a>
    </div>
  </div>
</body>
</html>