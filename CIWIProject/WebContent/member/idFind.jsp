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
	$('#idFindBtn').click(function(){
		var phone1=$('#phone1').val();
		var phone2=$('#phone2').val();
		var phone3=$('#phone3').val();
		if(phone1.trim()==""){
			$('#phone1').focus();
			return;
		}
		if(phone2.trim()==""){
			$('#phone2').focus();
			return;
		}
		if(phone3.trim()==""){
			$('#phone3').focus();
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
	<h2 class="text-center">아이디 찾기</h2><br>
		<div class="row">
			<form method="post" action="../member/idFind_ok.do">
				<table class="table">
					<tr>
						<th class="text-right" width=40% ><font size="2px">휴대폰번호로 찾기</font></th>
							<td class="text-left" width=60% name=phone id=phone>
								<select name=phone1 id=phone1>
									<option>번호선택</option>
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select> - 
								<input type=text  size=5 name=phone2 id=phone2> - 
								<input type=text  size=5 name=phone3 id=phone3>
							</td>
					</tr>
				</table>
				<table>
					<div class="text-center">
						<tr class="text-center">
							<input type=submit value="확인" class="btn btn-ms btn-info" id=idFindBtn>
						</tr>
					</div>
				</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>