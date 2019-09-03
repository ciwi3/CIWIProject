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
	$('.times').click(function(){
		var time=$(this).text();
		var hour=time.substring(0,time.indexOf(":"));
		var min=time.substring(time.indexOf(":")+1);
		var value=hour+"시 "+min+"분";
		
		// 다른 영화를 눌렀을 때 reserve_* 내용들 초기화
		$('#reserve_time').text("");
		$('#reserve_inwon').text("");
		$('#reserve_price').text("");
		
		$('#reserve_time').text(value); // reserve.jsp에서 출력
		
		$.ajax({
			type:'post',
			url:'inwon.do',
			success:function(response){
				$('#inwon').html(response);
			}
		})
	})
})
</script>
</head>
<body>
	<table class="table">
		<tr>
		<c:forEach var="time" items="${list }">
			<td>
				<span class="times btn btn-xs btn-info">${time }</span>
			</td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>