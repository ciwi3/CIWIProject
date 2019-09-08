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
							<th class="text-right" width=20% height=20%><font size="2px">충전할 캐시 : </font></th>
							<td class="text-left" width=80%>
								<input type=text size=20>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">이름 : </font></th>
							<td class="text-left" width=80%>${vo.name }
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">휴대폰번호 : </font></th>
							<td class="text-left" width=80%>${vo.phone }
							</td>
						</tr>
						<tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">우편번호 : </font></th>
							<td class="text-left" width=80%>${vo.post }
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">주소 : </font></th>
							<td class="text-left" width=80%>${vo.main_addr }
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">나의 문화취향 : </font></th>
							<td class="text-left" width=80%>${vo.genre }
							</td>
						</tr>
							<th class="text-right" width=20% ><font size="2px">내 보유캐시 : </font></th>
							<td class="text-left" width=80%> ${vo.mempay }&nbsp;&nbsp;Point
								&nbsp;&nbsp;<input type=submit  value="충전하기" class="btn btn-sm btn-info" id="cashChargeBtn">&nbsp;&nbsp;
							</td>
						</tr>
					</table>
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