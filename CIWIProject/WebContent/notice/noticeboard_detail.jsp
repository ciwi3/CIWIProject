<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../main_css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:900px;
}

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
function del() {
		var no = $('#no').val();
	 if (confirm("정말 삭제하시겠습니까??") == true){   //확인
			$.ajax({
				type:'post',
				url:'noticeboard_delete_ok.do',
				data:{no:no},
				success:function(response){
					location.href="../notice/noticeboard_list.do";
				}
			})
	 }else{   //취소
	     return false;

	 }

	}
</script>
</head>
<body>
	<div class="container">
	<h2 class="text-center" style="padding: 2ex;">${vo.dbday } 공지 사항</h2>
		<div class="row">
			<div style="height: auto; width: 100%; border:2px solid gold;">
			<table class="table">
				<tr>
					<th class="text-left">${vo.subject }</th>
					<th class="text-right">${vo.dbday }</th>
				</tr>
				<tr>
					<th class="text-left">관리자</th>
					<th class="text-right">조회수 : ${vo.hit }</th>
				</tr>
			</table>
			<table class="table" frame="void">
				<tr>
					<td colspan="2" class="text-left" valign="top" height="200">
					<pre style="white-space: pre-line;">${vo.content }</pre></td>
				</tr>
			</table>
			</div>
			<table class="table">
				<tr>
		          <td colspan="2" class="text-right">
			          <c:if test="${vo.id==id }">
			            <a href="noticeboard_update.do?no=${vo.no }&page=${curpage}" class="btn btn-sm btn-info">수정</a>
			            <input type="button" class="btn btn-sm btn-danger" onclick="del()" value="삭제">
			            <input type="hidden" name="no" value="${vo.no }" id="no">
			          </c:if>
		            <a href="noticeboard_list.do?page=${curpage }" class="btn btn-sm btn-info">목록</a>
		          </td>
		        </tr>
		     </table>
		</div>
	</div>
</body>
</html>