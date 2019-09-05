<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../main_css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:  400px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function () {
	$('#delBtn').click(function () {

		var no=$('#no').val();
		$.ajax({
			type:'post',
			url:'freeboard_delete_ok.do',
			data:{no:no},
			success:function(response){

				location.href="../community/freeboard_list.do";
			
			}
		});
	});
});
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">삭제하기</h2>
		<div class="row">
				<table class="table">
					<tr>
						<td class="text-center" width="100%">정말 삭제 하시겠습니까?
							<input type="hidden" name="no" value="${no }" id="no">
						</td>
					</tr>
					<tr>
						<td class="text-center" colspan="2">
							<input type="button" value="삭제" class="btn btn-sm btn-danger" id="delBtn">
							<input type="button" value="취소" class="btn btn-sm btn-primary"
								onclick="javascript:history.back()"
							>
						</td>
					</tr>
				</table>
		</div>	
	</div>
</body>
</html>