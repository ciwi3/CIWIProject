<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/bootstrap.min.js"></script>
<script src="../code.jquery.com/jquery.min.js"></script>
</head>
<body>
	<!-- HEADER -->
	<header id="header"> <!-- PAGE HEADER -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 text-center">
					<div class="author">
						<h1 class="text-uppercase">찜한 목록</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="author">
				<h3 class="text-uppercase">공연/행사 목록</h3>
			</div>
			<!-- row -->
			<div class="row">
				<c:forEach var="jjimSvo" items="${jjimSlist }">
					<div class="col-md-3">
						<!-- post -->
						<div class="poster">
							<a class="imges" href="../contents/show_detail.do?no=${jjimSvo.sno }"><img
								src="${jjimSvo.poster }" width=250px height=350px></a>
							<div class="post-body">
								<div class="post-category">
									<h3 class="post-title">
										<a href="../contents/show_detail.do?no=${jjimSvo.sno }">${jjimSvo.subject }</a>
									</h3>
								</div>
								<ul class="post-meta">
									<li>${jjimSvo.sdate }</li>
								</ul>
								<p>${jjimSvo.place }</p>
							</div>
						</div>
						<!-- /post -->
					</div>
				</c:forEach>
				<div class="col-md-12 text-right">
					<!-- <a href="../contents/festival.do">더보기</a> -->
					<hr>
				</div>
			</div>
		</div>
		<!-- /container -->
		<!-- container -->
		<div class="container">
			<div class="author">
				<h3 class="text-uppercase">페스티벌 목록</h3>
			</div>
			<!-- row -->
			<div class="row">
				<c:forEach var="jjimFvo" items="${jjimFlist }">
					<div class="col-md-3">
						<!-- post -->
						<div class="poster">
							<a class="imges" href="../contents/festival_detail.do?fno=${jjimFvo.fno }"><img
								src="${jjimFvo.poster }" width=250px height=350px></a>
							<div class="post-body">
								<div class="post-category">
									<h3 class="post-title">
										<a href="../contents/festival_detail.do?fno=${jjimFvo.fno }">${jjimFvo.subject }</a>
									</h3>
								</div>
								<ul class="post-meta">
									<li>${jjimFvo.fdate }</li>
								</ul>
								<p>${jjimFvo.place }</p>
							</div>
						</div>
						<!-- /post -->
					</div>
				</c:forEach>
				<div class="col-md-12 text-right">
					<!-- <a href="../contents/festival.do">더보기</a> -->
					<hr>
				</div>
			</div>
		</div>
		<!-- /container -->


	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>

</body>
</html>