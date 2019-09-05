<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function () {
	$('.btn-info').click(function () {
		var subject =$('#sub').val();
		if(subject.trim()==""){
			$('#sub').focus();
			return;
		}
		var content =$('#cont').val();
		if(content.trim()==""){
			$('#cont').focus();
			return;
		}

		$.ajax({
			type:'post',
			url:'qnaboard_insert_ok.do',
			data:{content:content,subject:subject},
			success:function(response){
				location.href="../notice/qnaboard.do";
			}
		})
	})
})

</script>
<style type="text/css">
.row{
	margin: 0px auto;
	width:  900px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="text-center" style="padding: 2ex;">Q&A 추가</h2>
		<div class="row">
			<form method="post" action="qnaboard_insert_ok.do">
				<table class="table">
					<tr>
						<td><strong> 자주 묻는 질문</strong></td>
						<td>
							<textarea rows="5" cols="70" name="subject" id="sub"></textarea>
						</td>
					</tr>
					<tr>
						<td><strong>답변</strong></td>
						<td>
							<textarea rows="20" cols="70" name="content" id="cont"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="추가" class="btn btn-sm btn-info">
							<input type="button" value="취소" class="btn btn-sm btn-danger"
								onclick="javascript:history.back()"
							>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>