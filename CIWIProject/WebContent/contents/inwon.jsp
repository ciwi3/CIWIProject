<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#inwonBtn').click(function(){ // 확인 버튼을 눌렀을 때
		var inwon=$('#inwon_sel').val();
		$('#reserve_inwon').text(inwon+'명');
		$('#reserve_price').text((inwon*12000)+'원');
		
		$('#reserve_btn').html('<input type="button" value="예매하기" class="btn btn-sm btn-info" onclick="reserve()">');
	})
})
</script>
</head>
<body>
	<table class="table">
		<tr>
			<td>
				인원:
				<select id="inwon_sel" class="input-sm" >
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
					<option>6</option>
					<option>7</option>
					<option>8</option>
					<option>9</option>
					<option>10</option>
				</select>
				<input type=button class="btn btn-sm btn-success" value=확인 id=inwonBtn>
			</td>
		</tr>
	</table>
</body>
</html>