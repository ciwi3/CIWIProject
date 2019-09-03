<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/s_style.css">
<script src="../js/bootstrap.min.js"></script>
<script src="../code.jquery.com/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">

				<h3 class="text-center">검색결과</h3>
<!-- 				<table class="table">
					<tr>
						<td class="text-left"><a href="list.do"
							class="btn btn-sm btn-success">목록</a></td>
					</tr>
				</table> -->
				
				<div class="genresearch">
						<c:if test="${count==0 }">
							<table class="table">
								<tr>
									<td class="text-center">검색한 결과가 없습니다.</td>
								</tr>
							</table>
						</c:if>
					<c:forEach var="svo" items="${slist }" varStatus="i">
						<c:if test="${count>0 }">
							<div class="col-md-3">
								<div class="poster">
									<a clsass="imges"
										href="../contents/show_detail.do?no=${svo.sno }"><img
										src="${svo.poster }" width=250px height=350px></a>
									<h5 class="post-title">
										<a href="../contents/show_detail.do?no=${svo.sno }">${svo.subject }</a>
									</h5>
									<ul class="post-meta">
										<li>${svo.sdate }</li>
									</ul>
									<h5><p>${svo.place }</p></h5>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



