<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>CIWI Template</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CMuli:400,700"
	rel="stylesheet">
<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="../index_css/bootstrap.min.css" />
<!-- Font Awesome Icon -->
<link type="text/css" rel="stylesheet"
	href="../main_css/bootstrap.min.css" />
<link rel="stylesheet" href="../main_css/font-awesome.min.css" />
<link rel="stylesheet"
	href="../main_scripts/ionicons/css/ionicons.min.css">
<link type="text/css" rel="stylesheet" href="../main_css/style.css" />
<link type="text/css" rel="stylesheet" href="../main_css/mainstyle.css" />

<link rel="stylesheet" href="../main_css/style.css">
</head>
<body>
	<!-- HEADER -->
	<header id="header">
		<!-- NAV -->
				<div id="nav">
		<!-- Top Nav -->
		<div id="nav-top">
			<div class="container">
				<div class="row">
					<div class="col-md-3 col-sm-12">
						<!-- logo -->
						<div class="nav-logo">
							<a href="../main/main.do" class="logo"><img
								src="../img/ciwilogo.png" style="width: 200px; height: 85px;"
								alt="CIWI Logo" style="padding-left:20px; "></a>
						</div>
						<!-- /logo -->
					</div>
					<!-- search & aside toggle -->
					<div class="col-md-6 col-sm-12"
						style="padding-top: 25px; padding-left: 40px;">
						<form class="search" autocomplete="off">
							<div class="form-group">
								<div class="input-group">
									<input type="text" name="q" class="form-control"
										placeholder="Search">
									<div class="input-group-btn">
										<button class="btn btn-primary">
											<i class="ion-search"></i>
										</button>
									</div>
								</div>
							</div>
						</form>
					</div><!-- 
					<div style="padding-left:100px;">
					</div> -->
					<div class="col-md-3 col-sm-12 text-right" style="padding-left: 50px;">
						<c:if test="${sessionScope.id==null }">
							<div style="padding-top: 35px;"><a href="../member/join.do"><img src="../img/plus.png" style="width: 25px; height: 26px;">  
									  <span>Sign up</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
									  <a href="../member/login.do"><img src="../img/profile.png" style="width: 25px; height: 26px;">  
									 <span>Login</span></a></div>
						</c:if>
						<c:if test="${sessionScope.id != null }">
 							<div><a href="../member/logout.do"><img src="../img/logout.png" style="width: 30px; height: 25px;">
									 <span>Logout</span></a></div> 
						</c:if>
					</div>
				</div>
			</div>
		</div>

		<%-- 
						<div class="nav-btns">
							<c:if test="${sessionScope.id==null }">
								<a href="../member/login.do" class="btn btn-sm btn-info">로그인</a>
							</c:if>
							<c:if test="${sessionScope.id != null }">
								<a href="../member/logout.do" class="btn btn-sm btn-danger">로그아웃</a>
							</c:if>
							<button class="aside-btn">
								<i class="fa fa-bars">메뉴</i>
							</button>
							<button class="search-btn">
								<i class="fa fa-search">검색</i>
							</button>
							<div id="nav-search">
								<form method="get" action="../main/unifiedsearch.do">
									<input class="input" name="text" placeholder="통합검색">
								</form>
								<button class="nav-close search-close">
									<span></span>
								</button>
							</div>
						</div>
						<!-- /search & aside toggle -->
					</div>
				</div>
			</div>
			<!-- /Top Nav --> --%>

		<!-- Main Nav -->
		<div id="nav-bottom">
			<div class="container">
				<!-- nav -->
				<ul class="nav-menu">
					<li class="has-dropdown"><a data-toggle="tab" href="#tab1">PAGES</a>
						<div class="dropdown">
							<div class="dropdown-body">
								<ul class="dropdown-list">
									<li><a data-toggle="tab" href="#tab1">ABOUT US</a></li>
									<li><a data-toggle="tab" href="#tab2">GUIED</a></li>
								</ul>
							</div>
						</div></li> &nbsp;&nbsp;&nbsp;
					<li class="has-dropdown"><a data-toggle="tab" href="#tab1">CULTURE</a>
						<div class="dropdown">
							<div class="dropdown-body">
								<!-- 									<div class="col-md-2">
 -->
								<ul class="dropdown-list">
									<li class="active"><a href="../contents/show.do">PERFORMANCE
											/ EXHIBITION</a></li>
									<li><a data-toggle="tab" href="#tab2">MOVIE</a></li>
									<li><a href="../contents/festival.do">CONCERT</a></li>
								</ul>
							</div>
						</div></li> &nbsp;&nbsp;&nbsp;
					<li class="has-dropdown"><a data-toggle="tab" href="#tab1">TICKETION</a>
						<div class="dropdown">
							<div class="dropdown-body">
								<!--  										<div class="col-md-3"> -->
								<!--<h4 class="dropdown-heading">Categories</h4> -->
								<ul class="dropdown-list">
									<li><a data-toggle="tab" href="#tab1">PERFORMANCE /
											EXHIBITION</a></li>
									<li><a href="../contents/reserve.do">MOVIE</a></li>
									<li><a data-toggle="tab" href="#tab3">CONCERT</a></li>
								</ul>
								<!-- 										</div> -->
							</div>
						</div></li>&nbsp;&nbsp;&nbsp;
					<li class="has-dropdown"><a data-toggle="tab" href="#tab1">COMMUNITY</a>
						<div class="dropdown">
							<div class="dropdown-body">
								<ul class="dropdown-list">
									<li><a href="../community/freeboard_list.do">FREE
											BOARD</a></li>
								</ul>
							</div>
						</div></li>&nbsp;&nbsp;&nbsp;
					<li class="has-dropdown"><a data-toggle="tab" href="#tab1">NOTICE</a>
						<div class="dropdown">
							<div class="dropdown-body">
								<ul class="dropdown-list">
									<li><a href="../notice/noticeboard_list.do">NOTICE</a></li>
									<li><a href="../notice/qnaboard.do">Q & A</a></li>
								</ul>
							</div>
						</div></li>&nbsp;&nbsp;&nbsp;

					</li>
					<c:if test="${sessionScope.id != null }">
						<li class="has-dropdown"><a data-toggle="tab" href="#">MY
								PAGE</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="../mypage/myinformation.do">MY INFORMATION</a></li>
										<li><a href="#tab2">MY WALLET</a></li>
										<li><a href="#tab2">MISSING</a></li>
										<li><a href="../mypage/jjim.do">보고싶어요</a></li>
										<li><a href="../member/join_modify.do">회원수정</a></li>

									</ul>
								</div>
							</div></li>&nbsp;&nbsp;&nbsp;
						</li>
					</c:if>
				</ul>
				<!-- /nav -->
			</div>
		</div>
		<!-- /Main Nav -->

		<!-- Aside Nav -->
		<div id="nav-aside">
			<ul class="nav-aside-menu">
				<li class="has-dropdown"><a href="#">홈페이지</a>
					<ul class="dropdown">
						<li><a href="#">소개</a></li>
						<li><a href="#">가이드</a></li>
					</ul>
				<li class="has-dropdown"><a>문화</a>
					<ul class="dropdown">
						<li><a href="#">공연 / 전시</a></li>
						<li><a href="#">영화</a></li>
						<li><a href="#">페스티발</a></li>
					</ul></li>
				<li class="has-dropdown"><a>커뮤니티</a>
					<ul class="dropdown">
						<li><a href="#">자유게시판</a></li>
					</ul></li>
				<li class="has-dropdown"><a>공지</a>
					<ul class="dropdown">
						<li><a href="#">공지사항</a></li>
						<li><a href="#">Q & A</a></li>
					</ul></li>
				<c:if test="${sessionScope.id != null }">
					<li class="has-dropdown"><a>내 페이지</a>
						<ul class="dropdown">
							<li><a href="../member/join_modify.do">회원정보 / 수정</a></li>
							<li><a href="#">내 지갑</a></li>
							<li><a href="#">보고싶어요</a></li>
						</ul></li>
			</ul>
			</c:if>
			<button class="nav-close nav-aside-close">
				<span></span>
			</button>
		</div>
		<!-- /Aside Nav -->
		<!-- 		</div> -->
		<!-- /NAV -->
	</header>
	<!-- /HEADER -->

	<!-- Aside Nav -->
	<div id="nav-aside">
		<ul class="nav-aside-menu">
			<li class="has-dropdown"><a href="#">홈페이지</a>
				<ul class="dropdown">
					<li><a href="#">소개</a></li>
					<li><a href="#">가이드</a></li>
				</ul>
			<li class="has-dropdown"><a>문화</a>
				<ul class="dropdown">
					<li><a href="#">공연 / 전시</a></li>
					<li><a href="#">영화</a></li>
					<li><a href="#">페스티발</a></li>
				</ul></li>
			<li class="has-dropdown"><a>커뮤니티</a>
				<ul class="dropdown">
					<li><a href="../community/freeboard_list.do">자유게시판</a></li>
				</ul></li>
			<li class="has-dropdown"><a>공지</a>
				<ul class="dropdown">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">Q & A</a></li>
				</ul></li>
			<c:if test="${sessionScope.id != null }">
				<li class="has-dropdown"><a>내 페이지</a>
					<ul class="dropdown">
						<li><a href="../member/join_modify.do">회원정보 / 수정</a></li>
						<li><a href="#">내 지갑</a></li>
						<li><a href="#">보고싶어요</a></li>
					</ul></li>
		</ul>
		</c:if>
		<button class="nav-close nav-aside-close">
			<span></span>
		</button>
	</div>
	<!-- /Aside Nav -->
	</div>
	<!-- /NAV -->
	</header>
	<!-- /HEADER -->

	<!-- include -->
	<jsp:include page="${main_jsp }" />

	<!-- FOOTER -->
	<footer id="footer">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-3">
					<div class="footer-widget">
						<p>Nec feugiat nisl pretium fusce id velit ut tortor pretium.
							Nisl purus in mollis nunc sed. Nunc non blandit massa enim nec.</p>
						<ul class="contact-social">
							<li><a href="#" class="social-facebook"><i
									class="fa fa-facebook"></i></a></li>
							<li><a href="#" class="social-twitter"><i
									class="fa fa-twitter"></i></a></li>
							<li><a href="#" class="social-google-plus"><i
									class="fa fa-google-plus"></i></a></li>
							<li><a href="#" class="social-instagram"><i
									class="fa fa-instagram"></i></a></li>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Categories</h3>
						<div class="category-widget">
							<ul>
								<li><a href="#">Lifestyle <span>451</span></a></li>
								<li><a href="#">Fashion <span>230</span></a></li>
								<li><a href="#">Technology <span>40</span></a></li>
								<li><a href="#">Travel <span>38</span></a></li>
								<li><a href="#">Health <span>24</span></a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Tags</h3>
						<div class="tags-widget">
							<ul>
								<li><a href="#">Social</a></li>
								<li><a href="#">Lifestyle</a></li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">Travel</a></li>
								<li><a href="#">Technology</a></li>
								<li><a href="#">Fashion</a></li>
								<li><a href="#">Life</a></li>
								<li><a href="#">News</a></li>
								<li><a href="#">Magazine</a></li>
								<li><a href="#">Food</a></li>
								<li><a href="#">Health</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="footer-widget">
						<h3 class="footer-title">Newsletter</h3>
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
				</div>
			</div>
			<!-- /row -->

			<!-- row -->
			<div class="footer-bottom row">
				<div class="col-md-6 col-md-push-6">
					<ul class="footer-nav">
						<li><a href="index.html">Home</a></li>
						<li><a href="about.html">About Us</a></li>
						<li><a href="contact.html">Contacts</a></li>
						<li><a href="#">Advertise</a></li>
						<li><a href="#">Privacy</a></li>
					</ul>
				</div>
				<div class="col-md-6 col-md-pull-6">
					<div class="footer-copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<!-- <script>
							document.write(new Date().getFullYear());
						</script> -->
						All rights reserved | Made with <i class="fa fa-heart-o"
							aria-hidden="true"></i> by <a href="https://colorlib.com"
							target="_blank">Colorlib</a> &amp; distributed by <a
							href="https://themewagon.com" target="_blank">ThemeWagon</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.min.js"></script>  
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>

	<script src="../mainjs/demo.js"></script>
	<script src="../mainjs/e-magz.js"></script>
	<script src="../mainjs/jquery.js"></script>
	<script src="../mainjs/jquery.migrate.js"></script>

	<script src="../main_scripts/jquery-number/jquery.number.min.js"></script>
	<script src="../main_scripts/owlcarousel/dist/owl.carousel.min.js"></script>
	<script
		src="../main_scripts/magnific-popup/dist/jquery.magnific-popup.min.js"></script>
	<script src="../main_scripts/easescroll/jquery.easeScroll.js"></script>
	<script src="../main_scripts/sweetalert/dist/sweetalert.min.js"></script>
	<script src="../main_scripts/toast/jquery.toast.min.js"></script>
</body>

</html>