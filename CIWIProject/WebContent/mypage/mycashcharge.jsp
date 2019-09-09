<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CIWI Template</title>
<link rel="stylesheet" href="../main_css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 700px;
	height:200px;
}
.row2 {
	margin: 0px auto;
	width: 700px;
	height:500px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#cashChargeBtn').click(function(){
		var pay=$('#pay').val();
		//alert(pay);
		$.ajax({
			type:'post',
			url:'../mypage/mycashcharge_ok.do',
			data:{pay:pay},
			success:function(response){
				alert("완료되었습니다. 승인처리 이후 사용가능합니다.");
				location.href="../mypage/myinformation.do";
			}
		});
	});
});
</script>
</head>
<body>
	<!-- HEADER -->
	<header id="header"> <!-- PAGE HEADER --> 
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 text-center">
					<div class="author">
						<h1 class="text-uppercase">내 지갑 충전하기</h1>
						<p class="lead"></p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->
	<!-- SESSION -->
		<div class="section">
		<div class="container">
			<h2 class="text-center">충전하기</h2>
				<div class="row2">
				<form action="../mypage/mycashcharge_ok.do"></form>
					<table class="table">
						<tr>
							<p style="font-size: 10px">충전할 Point를 입력해주세요.</p>
							<th class="text-right" width=20% height=20%><font size="2px">충전할 캐시 : </font></th>
							<td class="text-left" width=80%>
								<input id="pay" type=text size=20 placeholder="0" style = "text-align:right;" >&nbsp;&nbsp;Point
							</td>
							</tr>
					</table>
					<div class="text-center">
						<input type=button  value="충전하기" class="btn btn-ms btn-info" id="cashChargeBtn">
				</div>
					</div>
				</div>
				<!-- /container -->
			</div>
	<!-- /SECTION --> <!-- jQuery Plugins --> <script
		src="../js/jquery.min.js"></script> <script
		src="../js/bootstrap.min.js"></script> <script
		src="../js/jquery.stellar.min.js"></script> <script
		src="../js/main.js"></script>
</body>
</html>