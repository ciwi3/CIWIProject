<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HEADER --> 
	<header id="header"> 
		<!-- PAGE HEADER -->
		<div class="page-header">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-1 col-md-10 text-center">
						<div class="author">
							<h1 class="text-uppercase">공연／전시</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /PAGE HEADER -->
	</header>
	<!-- /HEADER -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<h1>${svo.subject }</h1>
				<table class="table">
					<tr >
						<td rowspan=2><img src="${svo.poster }" width=350px height=450px></td>
						<th>공연기간</th>
						<td>${svo.sdate }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${fvo.place }</td>
					</tr>
					<tr>
						<th>공연가격</th>
						<td>${fvo.price }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${svo.place }</td>
					</tr>
					<tr>
						<th>관람시간</th>
						<td>${svo.showtime }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${svo.tel }</td>
					</tr>
					<tr>
						<th>주최</th>
						<td>${svo.host }</td>
					</tr>
					<tr>
						<th>연령</th>
						<td>${svo.age}</td>
					</tr>
					<tr>
						<th>출처</th>
						<td>${svo.source}</td>
					</tr>
				</table>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	
	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>