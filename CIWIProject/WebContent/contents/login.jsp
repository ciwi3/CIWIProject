<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<style type="text/css">
.row {
	margin:0px auto;
	width:350px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		// 입력창에서 입력받은 값을 변수에 저장
		var id=$('#id').val();
		var pwd=$('#pwd').val();
		
		if(id.trim()=="") {
			$('#id').focus();
			return;
		}
		if(pwd.trim()=="") {
			$('#pwd').focus();
			return;
		}
		
		$('form').submit(); // 로그인 버튼을 눌렀을 때 form을 통해 내용을 보내고자 하는 곳에 전송함
	})
})
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">로그인</h2>
		<div class="row">
			<form method=post action="login_ok.do">
			<table class="table">
		        <tr>
		           <td class="text-right" width=20%>ID</td>
		           <td class="text-left" width=80%>
		              <input type=text name=id size=15 id=id>
		           </td>
		        </tr>
		         <tr>
		           <td class="text-right" width=20%>Password</td>
		           <td class="text-left" width=80%>
		              <input type=password name=pwd size=15 id=pwd>
		           </td>
		        </tr>
		        <tr>
		           <td colspan="2" class="text-center">
		              <input type="button" value="로그인" id=logBtn>
		              <input type="button" value="취소" id=canBtn>
		           </td>
		        </tr>
		     </table>
		     </form>
		</div>
	</div>
</body>
</html>