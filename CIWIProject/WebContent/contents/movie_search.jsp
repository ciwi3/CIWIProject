<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../main_css/s_style.css">
<script src="../js/bootstrap.min.js"></script>
<script src="../code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row"></div>
		<div class="section">
			<div class="col-md-10">
				<div class="genresearch">
					<c:if test="${count==0 }">
						<table class="table">
							<tr>
								<td class="text-center">검색한 결과가 없습니다.</td>
							</tr>
						</table>
					</c:if>
				</div> 
				<h3 class="text-center">검색결과</h3>
				<!-- 				<table class="table">
					<tr>
						<td class="text-left"><a href="list.do"
							class="btn btn-sm btn-success">목록</a></td>
					</tr>
				</table> -->
			</div>
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
									<p>${mvo.actor }</p>
								</div>
							</div>
							<!-- /post -->
							<hr>
						</div>
					</c:forEach>
				</div>
				<!-- /row -->
		
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
	</div>
</body>
</html>



