<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>예매 내역</h2>
		<div class="row">
			<table class="table">
				<tr>
					<td class="text-right">
						<a href="reserve.do" class="btn btn-sm btn-primary">예매</a>
					</td>
				</tr>
			</table>
			<table class="table table-striped">
				<tr class="success">
					<th>번호</th>
					<th>영화명</th>
					<th>극장명</th>
					<th>예매일</th>
					<th>상영시간</th>
					<th>인원</th>
					<th>결제하실 금액</th>
				</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.no }</td>
					<td>${vo.title }</td>
					<td>${vo.tname }</td>
					<td>${vo.rdate }</td>
					<td>${vo.rtime }</td>
					<td>${vo.inwon }</td>
					<td>${vo.price }</td>
					<td>
					<c:if test="${vo.result==0 }">
						<span class="btn btn-sm btn-danger">예매대기</span>
					</c:if>
					<c:if test="${vo.result==1 }"> 
						<span class="btn btn-sm btn-info">예매완료</span>
					</c:if>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>