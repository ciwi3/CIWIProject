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
	<table class="table">
		<c:forEach var="vo" items="${ rlist}">
			<tr>
				<td class="text-left"><strong
					style="font-size: large; color: orange;"> 작성자 : </strong>&nbsp;&nbsp;${vo.memid}</td>
				<td class="text-right"><strong
					style="font-size: large; color: orange;"> 평점 : </strong>
					&nbsp;&nbsp;${vo.rating}</td>
			</tr>
			<tr>
				<td colspan="2" class="text-left"><pre> ${vo.rtext }</pre></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>