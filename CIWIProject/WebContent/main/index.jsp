<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello C.I.W.I</title>

    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../index_css/bootstrap.min.css">

    <!-- FontAwesome CSS -->
    <link rel="stylesheet" href="../index_css/fontawesome-all.min.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="../index_css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="../index_css/style.css">
</head>

<body>
    <header class="site-header">
        <div class="header-bar">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-10 col-lg-4">
                        <h1 class="site-branding flex">
                            <a href="#">C.I.W.I</a>
                        </h1>
                    </div>

                            <!-- flex -->
                        </nav><!-- .site-navigation -->
                    </div><!-- .col-12 -->
                </div><!-- .row -->
            </div><!-- container-fluid -->
        </div><!-- header-bar -->
    </header><!-- .site-header -->

    <div class="hero-content">
        <div class="container">
            <div class="row">
                <div class="col-12 offset-lg-1 col-lg-10">
                    <div class="entry-header">
                        <h2 style="margin-right: 100px;">C.i.W.i</h2>
                    </div>
                    <!-- .entry-header -->
                    <div class="countdown flex flex-wrap justify-content-between" data-date="2018/06/06">
                        <div class="countdown-holder">
                            <div class="movie">${mCount }</div>
                            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            영화</label>
                        </div><!-- .countdown-holder -->

                        <div class="countdown-holder">
                            <div class="show">${sCount }</div>
                            <label style="margin-left: -25px;">&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;공연 / 전시</label>
                        </div><!-- .countdown-holder -->

                        <div class="countdown-holder">
                            <div class="festival">${fCount }</div>
                            <label>&nbsp;&nbsp;페스티발</label>
                        </div><!-- .countdown-holder -->
                    </div><!-- .countdown -->
                </div><!-- .col-12 -->
            </div><!-- row -->

            <div class="row">
                <div class="col-12 ">
                    <div class="entry-footer">
                        <a href="../member/login.do" class="btn btn-sm">로그인</a>&nbsp;&nbsp;&nbsp;
                        <a href="../member/join.do" class="btn btn-sm">회원가입</a><br><br>
                        <p>
                        <a href="../main/main.do" style="margin-right: 20px;">[ GUEST로 입장 ]</font></a>
                        </p>
                    </div>
                </div>
            </div>
        </div><!-- .container -->
    </div><!-- .hero-content --><!-- 
    <footer class="site-footer">
        <div class="footer-cover-title flex justify-content-center align-items-center">
            <h2>SUNFEST</h2>
        </div>.site-footer

        <div class="footer-content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="entry-title">
                            <a href="#">SUNFEST</a>
                        </div>entry-title

                        <div class="entry-mail">
                            <a href="#">SAYHELLO@SUNFEST.COM</a>
                        </div>.entry-mail

                  <div class="copyright-info">
                     Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.
                     Copyright &copy;
                     <script>
                        document.write(new Date().getFullYear());
                     </script>
                     All rights reserved | This template is made with
                     <i class="fa fa-heart" aria-hidden="true"></i> by 
                     <a href="https://colorlib.com" target="_blank">Colorlib</a>
                     Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.
                  </div>
                  copyright-info

                        <div class="footer-social">
                            <ul class="flex justify-content-center align-items-center">
                                <li><a href="#"><i class="fab fa-pinterest"></i></a></li>
                                <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fab fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fab fa-behance"></i></a></li>
                                <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                            </ul>
                        </div>footer-social
                    </div>col
                </div>row
            </div>container
        </div>footer-content-wrapper
    </footer>site-footer -->

    <script type='text/javascript' src='../index_js/jquery.js'></script>
    <script type='text/javascript' src='../index_js/masonry.pkgd.min.js'></script>
    <script type='text/javascript' src='../index_js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='../index_js/swiper.min.js'></script>
    <script type='text/javascript' src='../index_js/jquery.countdown.min.js'></script>
    <script type='text/javascript' src='../index_js/circle-progress.min.js'></script>
    <script type='text/javascript' src='../index_js/jquery.countTo.min.js'></script>
    <script type='text/javascript' src='../index_js/custom.js'></script>
</body>
</html>