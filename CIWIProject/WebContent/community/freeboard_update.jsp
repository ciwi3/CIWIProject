<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ciwi.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../main/css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:  900px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function () {
	$('.btn-primary').click(function () {
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
		var no = $('#no').val();
		var board_category= $('#board_category').val();
		//전송 
		$.ajax({
			type:'POST',
			url:'../community/freeboard_update_ok.do',
			data:{no:no,subject:subject,content:content,board_category:board_category},
			success:function(response){
				location.href="../community/freeboard_detail.do?no="+no;
			}
		});
	});
});
</script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">수정하기</h2>
		<div class="row">
			<form method="post" action="freeboard_update_ok.do">
				<table class="table">
					<tr>
						<th class="text-right info" width="20%">아이디</th>
						<td width="80%" class="text-left">
							<input type="text" name="name" size="15" class="input-sm" value="${vo.id }" id="name" readonly="readonly">
							<input type="hidden" name="no" value="${vo.no }" id="no">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">제목</th>
						<td width="80%" class="text-left">
							<input type="text" name="subject" size="30" class="input-sm" value="${vo.subject }" id="sub">
						</td>
					</tr>
					<th class="text-right info" width="20%">내용</th>
						<td width="80%" class="text-left">
							<textarea rows="10" cols="55" name="content" id="cont">${vo.content }</textarea>
						</td>
					</tr>
					<th class="text-right info" width="20%">게시글 분류</th>
						<td width="80%" class="text-left">
							<select id="board_category">
								<option>1.잡담</option>
								<option>2.질문</option>
								<option>3.정보공유</option>
								<c:if test="${admin==1 }">
									<option>4.공지사항</option>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="button" value="수정" class="btn btn-sm btn-primary">
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







