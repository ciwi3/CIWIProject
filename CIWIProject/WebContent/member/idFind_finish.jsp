<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
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
						<h2 class="text-center">고객님 아이디 찾기가 완료되었습니다.</h2><br><br>
						<table class="text-center">
							<tr>
								<th class="text-right" width=40%><font>아이디 :</font></th>&nbsp;
								<td class="text-left" width=60%><font>${id }</font></td>
							</tr>
							<tr>
								<th class="text-right" width=40%>이름 :</th>&nbsp;
								<td class="text-left" width=60%>${name }</td>
							</tr>
							<tr>
								<th class="text-right" width=40%>휴대폰번호 :</th>&nbsp;
								<td class="text-left" width=60%>${phone }</td>
							</tr>
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