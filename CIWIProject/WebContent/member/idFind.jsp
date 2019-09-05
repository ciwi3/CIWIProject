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
		var name=$('#name').val();
		var phone1=$('#phone1').val();
		var phone2=$('#phone2').val();
		var phone3=$('#phone3').val();
		if(name.trim()==""){
			$('#name').focus();
			return;
		}
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
		$.ajax({
			type:'post',
			url:'../member/idFind_ok.do',
			data:{name:name,phone1:phone1,phone2:phone2,phone3:phone3},
			success:function(response){
				if(response==0){
					alert("입력하신 정보와 일치하는 아이디가 없습니다. 다시 확인해주세요.");
					return;
				}else if(response==1){
					location.href="../member/idFind_finish.do";					
				}
			}
		});
	});
});
</script>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 700px;
	height:600px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="text-center">아이디 찾기</h2><br>
				<table class="table">
					<tr colspan="12">
						<th class="text-right" width=40% ><font size="2px">이름</font></th>
							<td class="text-left" width=60%>
								<input type=text size=20  name=name id="name">
							</td>
					</tr>
					<tr colspan="12">
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
				<div class="text-center" colspan="4">
					<input type=button value="확인" class="btn btn-ms btn-info" id=idFindBtn>
				</div>
			</div>
		</div>
	</div>
</body>
</html>