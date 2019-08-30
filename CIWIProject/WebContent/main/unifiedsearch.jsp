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
			<table class="table">
				<tr>
					<c:forEach var="fvo" items="${fList}">
						<td>${fvo.subject }</td>
					</c:forEach>
				</tr>
			</table>
			<table class="table">
				<tr>
					<c:forEach var="svo" items="${ sList}">
						<td>${fvo.subject }</td>
					</c:forEach>
				</tr>
			</table>
			<table class="table">
				<tr>
					<c:forEach var="mvo" items="${ mList}">
						<td>${mvo.title }</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>