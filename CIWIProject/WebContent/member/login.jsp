<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CIWI Template</title>
<link rel="stylesheet" href="../css2/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		var id=$('#id').val();
		var pwd=$('#pwd').val();
		if(id.trim()==""){
			$('#id').focus();
			return;
		}
		if(pwd.trim()==""){
			$('#pwd').val();
			return;
		}
	})
});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="text-center">로그인</h2><br>
				<table class="table">
					<tr colspan="12">
						<td class="text-center">
						<input type=text size=20 placeholder="아이디" name=id id="id">
						</td>
					</tr>
					<tr colspan="12">
						<td class="text-center">
							<input type=password name=pwd size=20 placeholder="비밀번호" id="pwd">
						</td>
					</tr>
					<tr>
						<td colspan="12" class="text-center">
							<input type="submit" value="로그인" id="loginBtn" href="#" class="btn btn-ms btn-success">
						</td>
					</tr>
				</table>
				<div class="text-center" colspan="4">
					<a href="#" class="btn btn-sm btn-info">아이디찾기</a>
					<a href="#" class="btn btn-sm btn-info">비밀번호찾기</a>
					<a href="../member/join.do" class="btn btn-sm btn-info">회원가입</a>
					</div>
			</div>
		</div>
	</div>
</body>
</html>