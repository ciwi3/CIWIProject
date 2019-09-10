<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#reserveBtn').click(function(){
		//$("#managementShow").load("../mypage/reservepage.do");
		$.ajax({
			url:'../mypage/mypage.do',
			success:function(){
			$('#managementShow').html();
			}
		})
	});
	$('#payBtn').click(function(){
		$("#managementShow").load("../mypage/mypage.do");
	});
});
</script>
</head>
<body>
	<div class="session">
		<div class="text-center"><br><br>
		<input type=button value="예매내역" class="btn btn-lg btn-info" id=reserveBtn>&nbsp;&nbsp;
		<input type=button value="결제내역" class="btn btn-lg btn-danger" id=payBtn><br><br>
		</div>
			<div id="managementShow"></div>
	</div>
</body>
</html>