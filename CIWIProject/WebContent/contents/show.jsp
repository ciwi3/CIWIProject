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
	<header id="header"> <!-- PAGE HEADER -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 text-center">
					<div class="author">
						<h1 class="text-uppercase">전시／공연</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->
	
	<!-- SEARCH -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">
				<form action="">
					<select class="options" name="genre">
						<optgroup label="장르">
							<c:forEach var="genre" items="${glist }">
								<option value="${genre}">${genre}</option>
							</c:forEach>
						</optgroup>
					</select>
					<select name="area">
						<optgroup label="지역">
							<c:forEach var="area" items="${alist }">
								<option>${area}</option>
							</c:forEach>
						</optgroup>
					</select>
					<select name="search">
						<optgroup label="제목">
							<option>제목</option>
							<option>내용</option>
						</optgroup>
					</select>
				</form>
			</div>
		</div>
	</div>
	<!-- SEARCH -->



	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<c:forEach var="svo" items="${slist }">
					<div class="col-md-3">
						<!-- post -->
						<div class="poster">
							<a class="imges" href="../contents/show_detail.do?no=${svo.sno }"><img
								src="${svo.poster }" width=250px height=350px></a>
							<div class="post-body">
								<div class="post-category">
									<h3 class="post-title">
										<a href="../contents/show_detail.do?no=${svo.sno }">${svo.subject }</a>
									</h3>
								</div>
								<ul class="post-meta">
									<li>${svo.sdate }</li>
								</ul>
								<p>${svo.place }</p>
							</div>
						</div>
						<!-- /post -->
						<hr>
					</div>
				</c:forEach>
			</div>
			<!-- /row -->
			<div class="section-row loadmore text-center">
				<a href="#" class="primary-button">Load More</a>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->


	<!-- jQuery Plugins -->
	<script src="js2/jquery.min.js"></script>
	<script src="js2/bootstrap.min.js"></script>
	<script src="js2/jquery.stellar.min.js"></script>
	<script src="js2/main.js"></script>

</body>
</html>