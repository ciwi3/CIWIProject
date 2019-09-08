<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../main_css/bootstrap.min.css">
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
		var id= $('#id').val();
		$.ajax({
			type:'post',
			url:'noticeboard_insert_ok.do',
			data:{id:id,content:content,subject:subject},
			success:function(response){
				location.href="../notice/noticeboard_list.do";
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
		<h2 class="text-center">공지 쓰기</h2>
		<div class="row">
			<form method="post" action="noticeboard_insert_ok.do">
				<table class="table">
					<tr>
						<th class="text-right info" width="20%">관리자명</th>
						<td width="80%" class="text-left">
							<input type="text" name="id" size="15" class="input-sm" value="${id }" readonly="readonly" id="id">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">제목</th>
						<td width="80%" class="text-left">
							<input type="text" name="subject" size="60" class="input-sm" id="sub">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">내용</th>
						<td width="80%">
							<textarea rows="20" cols="105" name="content" id="cont"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="공지 등록" class="btn btn-sm btn-info">
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