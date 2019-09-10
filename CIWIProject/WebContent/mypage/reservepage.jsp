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
	<div class="session">
		<div class="text-center"><br><br>
			<div class="container">
				<h2 >예매내역</h2>
				<div class="row">
					<table class="table table-striped">
				<tr class="warning">
					<th width=10% class="text-center">번호</th>
					<th width=10% class="text-center">아이디</th>
					<th width=10% class="text-center">영화명</th>
					<th width=10% class="text-center">극장명</th>
					<th width=15% class="text-center">예매일</th>
					<th width=10% class="text-center">예매시간</th>
					<th width=10% class="text-center">인원</th>
					<th width=10% class="text-center">금액</th>
					<th width=10% class="text-center">상태</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
					<td width=10% class="text-center">${vo.r_no }</td>
					<td width=10% class="text-center">${vo.r_id }</td>
					<td width=10% class="text-center">${vo.r_title }</td>
					<td width=10% class="text-center">${vo.r_tname }</td>
					<td width=10% class="text-center">${vo.r_rdate }</td>
					<td width=10% class="text-center">${vo.r_rtime }</td>
					<td width=10% class="text-center">${vo.r_inwon }</td>
					<td width=10% class="text-center">${vo.r_price }</td>
					<c:if test="${vo.r_state==0}">
							<td width=10% class="text-center">승인대기중</td>
					</c:if>
					<c:if test="${vo.r_state==1}">
							<td width=10% class="text-center">승인완료</td>
					</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>