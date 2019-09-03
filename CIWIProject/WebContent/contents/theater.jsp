<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.theaters').click(function(){
		var theater_name=$(this).attr("data-name"); // 클릭한 tr의 정보
		var theater_loc=$(this).attr("data-loc");
		var theater_no=$(this).attr("data-tno");
		var date_no=$(this).attr("data-dno");
		
		// 다른 영화를 눌렀을 때 reserve_* 내용들 초기화
		$('#reserve_theater').text("");
		$('#reserve_day').text("");
		$('#reserve_time').text("");
		$('#reserve_inwon').text("");
		$('#reserve_price').text("");
		
		$('#reserve_theater').text(theater_name); // reserve.jsp에서 출력
		
		// ajax로 date출력
		$.ajax({
			type:'post',
			url:'../contents/date.do',
			data:{date_no:date_no},
			success:function(response){
				$('#date').html(response);
			}
		})
	})
})
</script>
</head>
<body>
	<table class="table table-hover">
	<c:forEach var="vo" items="${tlist }">
		<tr class="theaters" data-name="${vo.theater_name }" data-loc="${vo.theater_loc }" data-tno="${vo.theater_no }" data-dno="${vo.date_no }">
			<td class="text-left">${vo.theater_name }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>