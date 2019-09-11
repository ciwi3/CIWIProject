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
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div id="hot-post" class="row hot-post">
				<div class="col-md-4 hot-post-left">
					<!-- post 1-->
					<div class="post post-thumb">
						<a class="post-img" href="../contents/festival_detail.do?fno=2"><img
							src="https://www.culture.go.kr/upload/rdf/19/08/rdf_2019082414445511491.jpg" width="200" height="500"></a>
						<div class="post-body">
							<div class="post-category">
								<a href="../contents/festival.do">Festival</a>
							</div>
							<h3 class="post-title title-lg">
								<a href="../contents/festival_detail.do?fno=2">원마운트 슈퍼문 페스티벌
								</a>
							</h3>
							<ul class="post-meta">
								<li>2019.09.06~15</li>
							</ul>
						</div>
					</div>
				</div>
					<!-- /post 2-->
				<div class="col-md-4 hot-post-left">
					<!-- post -->
					<div class="post post-thumb">
						<a class="post-img" href="../contents/movie_detail.do?no=3"><img
							src="http://viewers.heraldcorp.com/news/photo/201906/37340_33635_1750.jpg" width="200" height="500"></a>
						<div class="post-body">
							<div class="post-category">
								<a href="../contents/movie.do">movie</a>
							</div>
							<h3 class="post-title title-lg">
								<a href="../contents/movie_detail.do?no=3">엑스트</a>
							</h3>
							<ul class="post-meta">
								<li>2019.07.31. 개봉</li>
							</ul>
						</div>
					</div>
				</div>
					<!-- /post 3-->
				<div class="col-md-4 hot-post-left">
					<!-- post -->
					<div class="post post-thumb">
						<a class="post-img" href="../contents/show_detail.do?no=93"><img
							src="https://www.culture.go.kr/upload/rdf/19/08/rdf_201908169592494529.jpg" width="200" height="500"></a>
						<div class="post-body">
							<div class="post-category">
								<a href="../contents/show.do">concert</a>
							</div>
							<h3 class="post-title title-lg">
								<a href="../contents/show_detail.do?no=93">아몬드</a>
							</h3>
							<ul class="post-meta">
								<li>2019-09-19~25</li>
							</ul>
						</div>
					</div>
					<!-- /post -->
				</div>

			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-8">
					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2 class="title">공연/전시</h2>
							</div>
						</div>
						<!-- post -->
						<c:forEach var="svo" items="${slist }" varStatus="s">
							<div class="col-md-4">
								<c:if test="${s.index<3 }">
									<div class="post">
										<a class="post-img"
											href="../contents/show_detail.do?no=${svo.sno }"> <img
											src="${svo.poster }" alt=""
											style="width: 200px; height: 200px">
										</a>
										<div class="post-body">
											<div class="post-category">
												<a href="category.html">Travel</a>
											</div>
											<h3 class="post-title">
												<a href="../contents/show_detail.do?no=${svo.sno }">${svo.subject }</a>
											</h3>
											<ul class="post-meta">
												<li>${svo.host }</li>
												<li>${svo.place }</li>
												<li>${svo.sdate }</li>
											</ul>
										</div>
									</div>
								</c:if>
							</div>
						</c:forEach>
						<div class="col-md-12 text-right">
							<a href="../contents/show.do">더보기</a>
							<hr>
						</div>
						<!-- /post -->
					</div>
					<!-- /row -->

					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2 class="title">영화</h2>
							</div>
						</div>
						<!-- post -->
						<c:forEach var="mvo" items="${mlist }" varStatus="m">
							<div class="col-md-4">
								<c:if test="${m.index<3 }">
									<div class="post">
										<a class="post-img" href="../contents/movie_detail.do?no=${mvo.mno }">
											<img src="${mvo.poster }" style="width: 200px; height: 200px">
										</a>
										<div class="post-body">
											<div class="post-category">
												<a href="category.html">Travel</a>
											</div>
											<h3 class="post-title">
												<a href="../contents/movie_detail.do?no=${mvo.mno }">${mvo.title }</a>
											</h3>
											<ul class="post-meta">
												<li>${mvo.director }</li>
												<li>${mvo.genre }</li>
												<li>${mvo.regdate }</li>
											</ul>
										</div>
									</div>
								</c:if>
							</div>
						</c:forEach>
						<div class="col-md-12 text-right">
							<a href="../contents/movie.do">더보기</a>
							<hr>
						</div>
						<!-- /post -->
					</div>
					<!-- /row -->

					<!-- row -->
					<div class="row">
						<div class="col-md-12">
							<div class="section-title">
								<h2 class="title">행사/축제</h2>
							</div>
						</div>
						<!-- post -->
						<c:forEach var="fvo" items="${flist }" varStatus="f">
							<div class="col-md-4">
								<c:if test="${f.index<3 }">
									<div class="post">
										<a class="post-img"
											href="../contents/festival_detail.do?fno=${fvo.fno }"> <img
											src="${fvo.poster }" alt=""
											style="width: 200px; height: 200px">
										</a>
										<div class="post-body">
											<div class="post-category">
												<a href="category.html">Travel</a>
											</div>
											<h3 class="post-title">
												<a href="../contents/festival_detail.do?fno=${fvo.fno }">${fvo.subject }</a>
											</h3>
											<ul class="post-meta">
												<li>${fvo.host }</li>
												<li>${fvo.place }</li>
												<li>${fvo.fdate }</li>
											</ul>
										</div>
									</div>
								</c:if>
							</div>
						</c:forEach>
						<div class="col-md-12 text-right">
							<a href="../contents/festival.do">더보기</a>
							<hr>
						</div>
						<!-- /post -->
					</div>
					<!-- /row -->
					
				</div>
				<div class="col-md-4">
					<!-- ad widget-->
					<div class="aside-widget text-center">
						<a href="#" style="display: inline-block; margin: auto;"> <img
							class="img-responsive" src="../img/ad-2.jpg">
						</a>
					</div>
					<!-- /ad widget -->

					<!-- social widget -->
					<div class="aside-widget">
						<div class="section-title">
							<h2 class="title">Social Media</h2>
						</div>
						<div class="social-widget">
							<ul>
								<li><a href="#" class="social-facebook"> <i
										class="fa fa-facebook"></i> <span>21.2K<br>Followers
									</span>
								</a></li>
								<li><a href="#" class="social-twitter"> <i
										class="fa fa-twitter"></i> <span>10.2K<br>Followers
									</span>
								</a></li>
								<li><a href="#" class="social-google-plus"> <i
										class="fa fa-google-plus"></i> <span>5K<br>Followers
									</span>
								</a></li>
							</ul>
						</div>
					</div>
					<!-- /social widget -->

					<!-- category widget -->
					<div class="aside-widget">
						<div class="section-title">
							<h2 class="title">Categories</h2>
						</div>
						<div class="category-widget">
							<ul>
								<li><a href="../contents/show.do">공연/전시<span>${sTotal }</span></a></li>
								<li><a href="../contents/movie.do">영화 <span>${mTotal }</span></a></li>
								<li><a href="../contents/festival.do">행사 <span>${fTotal }</span></a></li>
							</ul>
						</div>
					</div>
					<!-- /category widget -->

					<!-- newsletter widget -->
					<div class="aside-widget">
						<div class="section-title">
							<h2 class="title">Newsletter</h2>
						</div>
						<div class="newsletter-widget">
							<form>
								<p>Nec feugiat nisl pretium fusce id velit ut tortor
									pretium.</p>
								<input class="input" name="newsletter"
									placeholder="Enter Your Email">
								<button class="primary-button">Subscribe</button>
							</form>
						</div>
					</div>
					<!-- /newsletter widget -->

					<!-- post widget -->
					<div class="aside-widget">
						<div class="section-title">
							<h2 class="title">Popular Posts</h2>
						</div>
						<!-- post -->
						<div class="post post-widget">
							<a class="post-img" href="blog-post.html"><img
								src="../img/widget-3.jpg" alt=""></a>
							<div class="post-body">
								<div class="post-category">
									<a href="category.html">Lifestyle</a>
								</div>
								<h3 class="post-title">
									<a href="blog-post.html">Ne bonorum praesent cum, labitur
										persequeris definitionem quo cu?</a>
								</h3>
							</div>
						</div>
						<!-- /post -->

						<!-- post -->
						<div class="post post-widget">
							<a class="post-img" href="blog-post.html"><img
								src="../img/widget-2.jpg" alt=""></a>
							<div class="post-body">
								<div class="post-category">
									<a href="category.html">Technology</a> <a href="category.html">Lifestyle</a>
								</div>
								<h3 class="post-title">
									<a href="blog-post.html">Mel ut impetus suscipit tincidunt.
										Cum id ullum laboramus persequeris.</a>
								</h3>
							</div>
						</div>
						<!-- /post -->

						<!-- post -->
						<div class="post post-widget">
							<a class="post-img" href="blog-post.html"><img
								src="../img/widget-4.jpg" alt=""></a>
							<div class="post-body">
								<div class="post-category">
									<a href="category.html">Health</a>
								</div>
								<h3 class="post-title">
									<a href="blog-post.html">Postea senserit id eos, vivendo
										periculis ei qui</a>
								</h3>
							</div>
						</div>
						<!-- /post -->

						<!-- post -->
						<div class="post post-widget">
							<a class="post-img" href="blog-post.html"><img
								src="../img/widget-5.jpg" alt=""></a>
							<div class="post-body">
								<div class="post-category">
									<a href="category.html">Health</a> <a href="category.html">Lifestyle</a>
								</div>
								<h3 class="post-title">
									<a href="blog-post.html">Sed ut perspiciatis, unde omnis
										iste natus error sit</a>
								</h3>
							</div>
						</div>
						<!-- /post -->
					</div>
					<!-- /post widget -->
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- ad -->
				<div class="col-md-12 section-row text-center">
					<a href="#" style="display: inline-block; margin: auto;"> <img
						class="img-responsive" src="../img/ad-2.jpg">
					</a>
				</div>
				<!-- /ad -->
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
<!-- 	<script src="../js/main.js"></script> -->

</body>
</html>