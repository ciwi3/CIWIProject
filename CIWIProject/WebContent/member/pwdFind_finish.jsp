<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CIWI Template</title>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-row">
					<c:if test="${res==1 }">
						<h2 class="text-center">고객님 비밀번호 찾기가 완료되었습니다.</h2><br><br>
						<table class="text-center">
							<tr>
								<th class="text-center"><h3>아이디 :</h3></th>&nbsp;
								<td class="text-center"><h3>${id }</h3></td>
							</tr>
							<tr>
								<th class="text-center" ><h3>비밀번호 :</h3></th>&nbsp;
								<td class="text-center" ><h3>${pwd }</h3></td>
							</tr>
					</c:if>
					<c:if test="${res==0 }">
						<h2 class="text-center">고객님의 비밀번호 검색 결과가 없습니다.</h2><br><br>		
					</c:if>
						</table>
						<div class="text-center">
							<a href="../main/main.do" class="primary-button">메인으로</a>
							<a href="../member/login.do" class="secondary-button">로그인</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>