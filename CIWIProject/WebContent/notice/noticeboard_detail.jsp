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
</head>
<body>
	<div class="container">
	<h1 class="text-center">내용보기</h1>
		<div class="row">
			<div style="height: auto; width: 100%; border:1px solid gold;">
			<table class="table">
				<tr>
					<th class="text-left">${vo.subject }</th>
					<th class="text-right">${vo.dbday }</th>
				</tr>
				<tr>
					<th class="text-left">${vo.id }</th>
					<th class="text-right">조회수 : ${vo.hit }</th>
				</tr>
			</table>
			<table class="table" frame="void">
				<tr>
					<td colspan="2" class="text-left" valign="top" height="200"><pre>${vo.content }</pre></td>
				</tr>
			</table>
			</div>
			<table class="table">
				<tr>
		          <td colspan="2" class="text-right">
			          <c:if test="${vo.id==id }">
			            <a href="noticeboard_update.do?no=${vo.no }" class="btn btn-sm btn-info">수정</a>
			            <a href="noticeboard_delete.do?no=${vo.no }" class="btn btn-sm btn-danger">삭제</a>
			          </c:if>
		            <a href="noticeboard_list.do?page=${curpage }" class="btn btn-sm btn-info">목록</a>
		          </td>
		        </tr>
		     </table>
		</div>
	</div>
</body>
</html>