<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>CIWI Template</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#pwdFindBtn').click(function(){
		var id=$('#id').val();
		if(id.trim()==""){
			alert("찾으실 아이디를 입력해주세요.")
			$('#id').focus();
			return;
		}
	});
});
</script>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
	<h2 class="text-center">비밀번호 찾기</h2><br>
		<div class="row">
			<form method="post" action="../member/pwdFind_ok.do">
				<table class="table">
					<tr>
						<th class="text-right" width=40% ><font size="2px">아이디로 찾기</font></th>
							<td class="text-left" width=60% name=phone id=phone>
								<input type=text id=id	name=id placeholder="아이디">
							</td>
					</tr>
				</table>
				<table>
					<div class="text-center">
						<tr class="text-center">
							<input type=submit value="확인" class="btn btn-ms btn-info" id=pwdFindBtn>
						</tr>
					</div>
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>