<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/s_style.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">
				<form action="">
					<select class="options">
						<optgroup label="장르">
							<c:forEach var="svo" items="${slist }">
								<option>${svo.genre}</option>	
							</c:forEach>
						</optgroup>
						<optgroup label="지역">
							<c:forEach var="svo" items="${slist }">
								<option>${svo.area}</option>
							</c:forEach>
						</optgroup>
						<optgroup label="제목">
							<option>제목</option>
							<option>내용</option>
						</optgroup>
					</select>
				</form>
			</div>
		</div>
	</div>
	
	
</body>
</html>