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
	<!-- Page header -->
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-sm-12 col-xs-12">
				<h3>공연／전시</h3>
			</div>
		</div>
	</div>
	<!--  /page header -->
	
	<!-- SECTION  -->
	<div id="showContents">
		<div class="container">
			<div class="row">
				<div class="todayShow">
					<!-- 오늘의 공연 전시 -->
				</div>
				<div class="search">
					<!-- 공연전시 내 검색 -->
				</div>
				<div class="showList">
					<c:forEach var="svo" items="${slist }">
						<div class="show-info">
							<div class="poster">
								<a class=images href="../show/show_detail.do?no=${svo.sno}">
								<img src="${svo.poster }" style="width: 250px; height: 350px;"></a>
							</div>
							<div class="poster-info">
								<dl>
									<dt style="font: bold;">
										<a href="../show/show_detail.do?no=${svo.sno}">
										${svo.subject}
										</a>
									</dt>
									<dt>${svo.sdate }</dt>
									<dd>${svo.place }</dd>
								</dl>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>