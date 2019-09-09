<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="../main_css/s_style">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		var sno = ${svo.sno};
		$('#jjim').click(function() {
			$.ajax({
				type : 'post',
				url : '../contents/show_jjim_ok.do',
				data : {sno:sno},
				success : function(res) {
					location.href = '../contents/show_detail.do?no=' + sno;
				}
			})
		})
	})
</script>
</head>
<body>
	<!-- HEADER -->
	<header id="header"> <!-- PAGE HEADER -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 text-center">
					<div class="author">
						<h1 class="text-uppercase">공연／전시</h1>
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
			<!-- row -->
			<div class="row"
				style="margin-top: 30px; margin-left: 45px; margin-right: 45px;">
				<div class="col-sm-10">
					<h3 style="font: bold;">${svo.subject }</h3>
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
					<a href="../contents/show.do" class="btn btn-sm btn-danger">목록</a>
				</div>
				<table class="table">
					<tr>
						<td rowspan=2><img src="${svo.poster }" width=350px
							height=450px></td>
						<th>공연기간</th>
						<td>${svo.sdate }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${svo.place }</td>
					</tr>
					<tr>
						<th>공연가격</th>
						<td>${svo.price }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${svo.place }</td>
					</tr>
					<tr>
						<th>관람시간</th>
						<td>${svo.showtime }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${svo.tel }</td>
					</tr>
					<tr>
						<th>주최</th>
						<td>${svo.host }</td>
					</tr>
					<tr>
						<th>연령</th>
						<td>${svo.age}</td>
					</tr>
					<tr>
						<th>출처</th>
						<td>${svo.source}</td>
					</tr>
				</table>
			</div>
			<!-- /row -->
			<div style="margin-left: 40px;">
				<br> <br> <br>
				<div class="col-sm-10">
					<textarea cols="10" placeholder="리뷰를 입력하세요." name="review"
						class="form-control"></textarea>
				</div>
			</div>
		</div>
		<!-- /container -->
		<table>
			<tr>
				<c:forEach var="vo" items="${list }">
					<td>${vo.rating}</td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<!-- /SECTION -->


	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>