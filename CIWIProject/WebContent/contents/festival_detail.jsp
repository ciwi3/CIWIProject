<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
table {
}
</style>
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
				<h1>${fvo.subject }</h1>
				<table class="table">
					<tr>
						<td rowspan=4><img src="${fvo.poster }" width=350 height=350></td>
						<th>기간</th>
						<td>${fvo.fdate }</td>
					</tr>
					<tr>
						<th>장소</th>
						<td>${fvo.place }</td>
					</tr>
					<tr>
						<th>주최</th>
						<td>${fvo.host }</td>
					</tr>
					<tr>
						<th>문의</th>
						<td>${fvo.tel }</td>
					</tr>
				</table>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->

	
	<!-- jQuery Plugins -->
	<script src="../js2/jquery.min.js"></script>
	<script src="../js2/bootstrap.min.js"></script>
	<script src="../js2/jquery.stellar.min.js"></script>
	<script src="../js2/main.js"></script>
</body>
</html>