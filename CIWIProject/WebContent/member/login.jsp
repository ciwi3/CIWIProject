<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>CIWI Template</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- <style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style> -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#loginBtn').click(function(){
		var id=$('#id').val();
		var pwd=$('#pwd').val();
		//공란이면 포커스..가게.. 
		if(id.trim()==""){
			$('#id').focus();
			return;
		}
		if(pwd.trim()==""){
			$('#pwd').focus();
			return;
		}
		//데이터 넘겨주기 = form태그로   / 그럼 만들어줘야겠지?
				$('#loginfrm').submit();
	})
});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="text-center">로그인</h2><br>
			<form method=post action="../member/login_ok.do" id="loginfrm">
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
							<input type="button" value="로그인" id="loginBtn" class="btn btn-ms btn-success">
						</td>
					</tr>
				</table>
				</form>
				<div class="text-center">
						<a href="../member/idFind.do" class="btn btn-sm btn-info" >아이디찾기</a>
						<a href="../member/pwdFind.do" class="btn btn-sm btn-info" >비밀번호찾기</a>
						<a href="../member/join.do" class="btn btn-sm btn-info">회원가입</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>