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
		$('#reserve').show();
		$('#pay').hide();
	});
	$('#payBtn').click(function(){
		$('#pay').show();
		$('#reserve').hide();
	});
	$('.cashOkBtn').click(function(){
		var id=$(this).attr("data-id");
		//alert(id);
		$.ajax({
			type:'post',
			url:'../mypage/cashOk.do',
			data:{id:id},
			success:function(response){
			}
		});
	});
	$('.cashNoBtn').click(function(){
		var id=$(this).attr("data-id");
		//alert(id);
		$.ajax({
			type:'post',
			url:'../mypage/cashNo.do',
			data:{id:id},
			success:function(response){
			}
		});
	});
});
</script>
</head>
<body>
	<div class="session">
		<div class="text-center"><br><br>
		<input type=button value="예매내역" class="btn btn-lg btn-info" id=reserveBtn>&nbsp;&nbsp;
		<input type=button value="결제내역" class="btn btn-lg btn-danger" id=payBtn><br><br>
		<div class="container" id=reserve style="display: none">
				<h2 >예매내역</h2>
				<div class="row">
					<table class="table table-striped">
						<tr class="success">
							<th width=10% class="text-center">번호</th>
							<th width=10% class="text-center">아이디</th>
							<th width=10% class="text-center">충전 날짜</th>
							<th width=10% class="text-center">충전 금액</th>
							<th width=10% class="text-center">현재처리상태</th>
						</tr>
						<c:forEach var="vo" items="${list }">
							<tr>
							<td>${vo.cash_no }</td>
							<td>${vo.cash_id }</td>
							<td>${vo.cash_date }</td>
							<td>${vo.cash_pay }</td>
							<c:if test="${vo.cash_state==0}">
							<td>승인대기중</td>
							</c:if>
							<c:if test="${vo.cash_state==1}">
							<td>승인처리완료</td>
							</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			
			<div class="container" id=pay style="display: none">
				<h2 >결제내역</h2>
				<div class="row">
					<table class="table table-striped">
						<tr class="success">
							<th width=10% class="text-center">번호</th>
							<th width=10% class="text-center">아이디</th>
							<th width=10% class="text-center">충전 날짜</th>
							<th width=10% class="text-center">충전 금액</th>
							<th width=10% class="text-center">현재처리상태</th>
						</tr>
						<c:forEach var="vo" items="${list }">
							<tr>
							<td>${vo.cash_no }</td>
							<td>${vo.cash_id }</td>
							<td>${vo.cash_date }</td>
							<td>${vo.cash_pay }</td>
							<c:if test="${vo.cash_state==0}">
							<td>승인대기중</td>
							</c:if>
							<c:if test="${vo.cash_state==1}">
							<td>승인처리완료</td>
							</c:if>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
</div>
</body>
</html>