<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

</head>
<body>
	<div class="container">
		<div class="row">
			<!-- 축제  -->
			<p>
			<h3 class="text-left" style="display: inline;">축제</h3>
			<span style="margin-left: 980px"><a href="#">더보기</a></span>
			<p>
			<table class="table">
				<c:forEach var="fvo" items="${fList}" varStatus="i">
					<c:if test="${i.index%4==0 }">
						<tr>
					</c:if>
					<c:if test="${i.index<8 }">
					<td class="text-left">
						<ul class="text-center">
							<a href="../contents/festival_detail.do?fno=${fvo.fno }">
								<li><img src="${fvo.poster }" width="80px" height="100px"></li>
								<li>${fvo.subject }</li>
							</a>
						</ul>
					</td>
					</c:if>
					<c:if test="${i.index%4==3 || i.last == true}">
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<!-- 공연전시 -->


			<p>
			<h3 class="text-left" style="display: inline;">공연 전시</h3>
			<span style="margin-left: 980px"><a href="#">더보기</a></span>
			<p>
			<table class="table">
				<c:forEach var="svo" items="${sList}" varStatus="i">
					<c:if test="${i.index%4==0 }">
						<tr>
					</c:if>
					<td class="text-left">
						<ul class="text-center">
							<a href="../contents/show_detail.do?no=${svo.sno }">
								<li><img src="${svo.poster }" width="80px" height="100px"></li>
								<li>${svo.subject }</li>
							</a>
						</ul>
					</td>
					<c:if test="${i.index%4==3 || i.last == true}">
						</tr>
					</c:if>
				</c:forEach>
			</table>

			<!-- 영화 -->
			<p>
			<h3 class="text-left" style="display: inline;">영화</h3>
			<span style="margin-left: 980px"><a href="#">더보기</a></span>
			<p>
			<table class="table">
				<c:forEach var="mvo" items="${mList}" varStatus="i">
					<c:if test="${i.index%4==0 }">
						<tr>
					</c:if>
					<td class="text-left">
						<ul class="text-center">
							<a href="../contents/movie_detail.do?no=${mvo.mno }">
								<li><img src="${mvo.poster }" width="80px" height="100px"></li>
								<li>${mvo.title }</li>
							</a>
						</ul>
					</td>
					<c:if test="${i.index%4==3 || i.last == true}">
						</tr>
					</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>