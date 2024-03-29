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
						<h1 class="text-uppercase">영화</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->

	<!-- SEARCH -->
	<form method="get" action="../contents/movie_search.do">
		<div class="container-fluid">
			<div class="row">
				<div style="padding: 50px, 20px, 20px, 50px">
					<select class="options" name="genre">
						<optgroup label="장르">
							<option selected>전체</option>
							<c:forEach var="genre" items="${glist }">
								<option value="${genre.movie_no}">${genre.movie_genre}</option>
							</c:forEach>
						</optgroup>
					</select> <select name="onScreen">
						<optgroup label="상영여부">
							<option value="1" selected="selected">상영중</option>
							<option value="0">전체</option>
						</optgroup>
					</select> <select name="search">
						<optgroup>
							<option selected="selected">제목</option>
							<option>배우</option>
							<option>감독</option>
						</optgroup>
					</select> <input type="text" size=20 name="mtext" alt="Search"> <input
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
				<c:forEach var="mvo" items="${mlist }">
					<div class="col-md-3">
						<!-- post -->
						<div class="poster">
							<a class="imges"
								href="../contents/movie_detail.do?no=${mvo.mno }"><img
								src="${mvo.poster }" width=250px height=350px></a>
							<div class="post-body">
								<div class="post-category">
									<h3 class="post-title">
										<a href="../contents/movie_detail.do?no=${mvo.mno }">${mvo.title }</a>
									</h3>
								</div>
								<ul class="post-meta">
									<li>${mvo.regdate }</li>
								</ul>
								<p>${mvo.score}</p>
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
						<li><a href="movie.do?page=1">◁</a></li>
						<li><a href="movie.do?page=${startPage-1 }">&lt;</a></li>
					</c:if>
					<c:forEach var="i" begin="${startPage }" end="${endPage }">
						<li class=${curPage==i? "active":"" }><a
							href="movie.do?page=${i }">${i }</a></li>
					</c:forEach>
					<c:if test="${endPage<allPage }">
						<li><a href="movie.do?page=${endPage+1 }">&gt;</a></li>
						<li><a href="movie.do?page=${allPage }">▷</a></li>
					</c:if>
				</ul>
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