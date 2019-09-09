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
						<h1 class="text-uppercase">전시／공연</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->

	<!-- SEARCH -->
	<form method="get" action="../contents/show_search.do">
		<div class="container-fluid">
			<div class="row">
				<div style="padding: 50px,20px,20px,50px">
					<select class="options" name="genre">
						<optgroup label="장르">
						<option selected>전체</option>
							<c:forEach var="genre" items="${glist }">
								<option value="${genre.show_no}">${genre.show_genre}</option>
							</c:forEach>
						</optgroup>
					</select> <select name="area">
						<optgroup label="지역">
							<option selected>전체</option>
							<c:forEach var="area" items="${alist }">
								<option value="${area.area_no }">${area.area_name}</option>
							</c:forEach>
						</optgroup>
					</select> <select name="search">
							<optgroup>
							
								<option >제목</option>
								<option >내용</option>
							</optgroup>
						</select> <input type="text" size=20 name="stext" alt="Search"> <input
							type="submit" class="btn btn-sm">
					</div>
				</div>
			</div>
		</form>
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
							<a clsass="imges" href="../contents/show_detail.do?no=${svo.sno }"><img
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
			<div class="row text-center">
				<ul class="pagination pagination-lg">
					<c:if test="${curPage>BLOCK }">
						<li><a href="show.do?page=1">◁</a></li>
						<li><a href="show.do?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li class=${curPage==i? "active":"" }><a
							href="show.do?page=${i }">${i }</a></li>
					</c:forEach>
					<c:if test="${endPage<allPage }">
						<li><a href="show.do?page=${endPage+1 }">&gt;</a></li>
						<li><a href="show.do?page=${allPage }">▷</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->


	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
<!-- 	<script src="js2/main.js"></script> -->

</body>
</html>