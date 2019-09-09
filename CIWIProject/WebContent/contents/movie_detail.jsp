<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	var mno=${mvo.mno};
	$('#jjim').click(function(){
		$.ajax({
			type:'post',
			url:'../contents/movie_jjim_ok.do',
			data:{mno:mno},
			success:function(res) {
				location.href='../contents/movie_detail.do?no='+mno;
			}
		})
	})
})
</script>
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
							<h1 class="text-uppercase">영화</h1>
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
				<div class="col-sm-10">
					<h1>${mvo.title }</h1>
				</div>
				<c:if test="${sessionScope.id==null }">
				<div class="col-sm-1">
					<a href="../member/login.do">
						<input type="button" class="btn btn-sm btn-warning" value="로그인 필요">
					</a>
				</div>
				</c:if>
				<c:if test="${sessionScope.id!=null }">
					<div class="col-sm-1">
					<c:if test="${flag==0 }">
						<input type="button" class="btn btn-sm btn-warning" id="jjim" value="보고싶어요">
					</c:if>
					<c:if test="${flag!=0 }">
						<input type="button" class="btn btn-sm btn-danger" id="jjim" value="등록 취소">
					</c:if>
					</div>
				</c:if>
				<div class="col-sm-1">
					<a href="../contents/movie.do" class="btn btn-sm btn-danger">목록</a>
				</div>
				<table class="table">
					<tr >
						<td rowspan=2><img src="${mvo.poster }" width=350px height=450px></td>
						<th>상영기간</th>
						<td>${mvo.regdate }</td>
					</tr>
					<tr>
						<th>배우</th>
						<td>${mvo.actor }</td>
					</tr>
					<tr>
						<th>감독</th>
						<td>${mvo.director }</td>
					</tr>
					<tr>
						<th>등급</th>
						<td>${mvo.grade}</td>
					</tr>
					<tr>
						<th>장르</th>
						<td>${mvo.genre}</td>
					</tr>
					<tr>
						<th>평점</th>
						<td>${mvo.score }</td>
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