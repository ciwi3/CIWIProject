<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
   <title>CIWI Template</title>
   <!-- Google font -->
   <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700%7CMuli:400,700" rel="stylesheet">
   <!-- Bootstrap -->
   <link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />
   <!-- Font Awesome Icon -->
   <link rel="stylesheet" href="../css/font-awesome.min.css">
   <!-- Custom stlylesheet -->
   <link type="text/css" rel="stylesheet" href="../css/style.css" />
</head>
<body>
   <!-- HEADER -->
   <header id="header">
      <!-- NAV -->
      <div id="nav">
         <!-- Top Nav -->
         <div id="nav-top">
            <div class="container">
               <!-- social 
               <ul class="nav-social">
                  <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                  <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                  <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                  <li><a href="#"><i class="fa fa-instagram"></i></a></li>
               </ul>
               /social -->

               <!-- logo -->
               <div class="nav-logo">
                  <a href="../main/main.do" class="logo"><img src="../img/ciwilogo2.png" alt=""></a>
               </div>
               <!-- /logo -->

               <!-- search & aside toggle -->
               <div class="nav-btns">
                  <button class="aside-btn"><i class="fa fa-bars"></i></button>
                  <button class="search-btn"><i class="fa fa-search"></i></button>
                  <div id="nav-search">
                     <form>
                        <input class="input" name="search" placeholder="통합검색">
                     </form>
                     <button class="nav-close search-close">
                        <span></span>
                     </button>
                  </div>
               </div>
               <!-- /search & aside toggle -->
            </div>
         </div>
         <!-- /Top Nav -->

         <!-- Main Nav -->
			<div id="nav-bottom">
				<div class="container">
					<!-- nav -->
					<ul class="nav-menu">
						<li class="has-dropdown">
							<a href="#">소개</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">소개</a></li>
										<li><a href="#">가이드</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li class="has-dropdown">
							<a href="#">문화</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">공연, 전시</a></li>
										<li><a href="#">영화</a></li>
										<li><a href="../contents/festival.do">행사</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li class="has-dropdown">
							<a href="#">예약</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">공연,전시</a></li>
										<li><a href="#">영화</a></li>
										<li><a href="#">축제</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a href="#">커뮤니티</a></li>
						<li class="has-dropdown">
							<a href="#">고객센터</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">공지사항</a></li>
										<li><a href="#">자주묻는 질문</a></li>
									</ul>
								</div>
							</div>
						</li>
						<li class="has-dropdown">
							<a href="#">마이페이지</a>
							<div class="dropdown">
								<div class="dropdown-body">
									<ul class="dropdown-list">
										<li><a href="#">내지갑</a></li>
										<li><a href="#">보고싶어요</a></li>
										<li><a href="#">회원수정</a></li>
									</ul>
								</div>
							</div>
						</li>
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
                  </ul>
               </li>
               <li class="has-dropdown"><a>커뮤니티</a>
                  <ul class="dropdown">
                     <li><a href="#">자유게시판</a></li>
                  </ul>
               </li>
               <li class="has-dropdown"><a>공지</a>
                  <ul class="dropdown">
                     <li><a href="#">공지사항</a></li>
                     <li><a href="#">Q & A</a></li>
                  </ul>
               </li>
               <li class="has-dropdown"><a>내 페이지</a>
                  <ul class="dropdown">
                     <li><a href="#">회원정보 / 수정</a></li>
                     <li><a href="#">내 지갑</a></li>
                     <li><a href="#">보고싶어요</a></li>
                  </ul>
               </li>
            </ul>
            <button class="nav-close nav-aside-close"><span></span></button>
         </div>
         <!-- /Aside Nav -->
      </div>
      <!-- /NAV -->
   </header>
   <!-- /HEADER -->
   
   <!-- include -->
   <jsp:include page="${main_jsp }"/>

   <!-- FOOTER -->
   <footer id="footer">
      <!-- container -->
      <div class="container">
         <!-- row -->
         <div class="row">
            <div class="col-md-3">
               <div class="footer-widget">
                  <p>Nec feugiat nisl pretium fusce id velit ut tortor pretium. Nisl purus in mollis nunc sed. Nunc non blandit massa enim nec.</p>
                  <ul class="contact-social">
                     <li><a href="#" class="social-facebook"><i class="fa fa-facebook"></i></a></li>
                     <li><a href="#" class="social-twitter"><i class="fa fa-twitter"></i></a></li>
                     <li><a href="#" class="social-google-plus"><i class="fa fa-google-plus"></i></a></li>
                     <li><a href="#" class="social-instagram"><i class="fa fa-instagram"></i></a></li>
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
                        <p>Nec feugiat nisl pretium fusce id velit ut tortor pretium.</p>
                        <input class="input" name="newsletter" placeholder="Enter Your Email">
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
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | Made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a> &amp; distributed by <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
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
   <script src="../js/jquery.min.js"></script>
   <script src="../js/bootstrap.min.js"></script>
   <script src="../js/jquery.stellar.min.js"></script>
   <script src="../js/main.js"></script>

</body>

</html>