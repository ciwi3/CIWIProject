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
		var tname=$(this).attr("data-name"); // 클릭한 tr의 정보
		var tloc=$(this).attr("data-loc");
		var tno=$(this).attr("data-tno");
		var dno=$(this).attr("data-dno");
		$('#reserve_theater').text(tname+"-"+tloc); // reserve.jsp에서 출력
		
		// ajax로 date출력
		$.ajax({
			type:'post',
			url:'../movie/date.do',
			data:{dno:dno},
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
	<c:forEach var="vo" items="${list }">
		<tr class="theaters" data-name="${vo.tname }" data-loc="${vo.tloc }" data-tno="${vo.tno }" data-dno="${vo.dno }">
			<td class="text-left">${vo.tname }(${vo.tloc })</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>