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
							<h1 class="text-uppercase">행사, 축제</h1>
							<p class="lead">리스트를 통해 어떤 행사 및 축제가 있는지 확인하고, 원하는 내용의 정보를 얻어 직접 즐겨보세요!</p>
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
			<c:forEach var="svo" items="${slist }">
			<div class="row">
				<div class="col-md-10">
					<!-- post -->
					<div class="post post-row">
						<a class="post-img" href="../contents/show_detail.do?fno=${svo.sno }"><img src="${svo.poster }" width=100 height=200 alt=""></a>
						<div class="post-body">
							<div class="post-category">
								<h3 class="post-title"><a href="../contents/show_detail.do?fno=${svo.sno }">${svo.subject }</a></h3>
							</div>
							<ul class="post-meta">
								<li>${svo.host }</li>
								<li>${svo.fdate }</li>
							</ul>
							<p>${svo.place }</p>
						</div>
					</div>
					<!-- /post -->
					<hr>
				</div>
			</div>
			</c:forEach>
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