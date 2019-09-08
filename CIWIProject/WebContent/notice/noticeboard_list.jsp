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
}
.h1{
 font-family: "Times New Roman", Times, serif;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="text-center h1" style="padding: 2ex;" ><strong>C.I.W.I 공지사항</strong></h1>
		<div class="row">
			<table class="table">
				<tr>
		          <th width=10% class="text-center"></th>
		          <th width=45% class="text-center">제목</th>
		          <th width=15% class="text-center">작성자</th>
		          <th width=20% class="text-center">작성일</th>
		          <th width=10% class="text-center">조회수</th>
				</tr>
				<c:forEach var="vo" items="${list }" varStatus="s">
		           <tr>
		             <td width=10% class="text-center">${count }</td>
		             <td width=45% class="text-left"><a href="noticeboard_detail.do?no=${vo.no }&page=${curpage }">${vo.subject }</a>
		             	<c:if test="${today==vo.dbday }">
		             		<sup><font color=red>new</font></sup>
		             	</c:if>
		             </td>
		             <td width=15% class="text-center">${vo.id }</td>
		             <td width=20% class="text-center">${vo.dbday }</td>
		             <td width=10% class="text-center">${vo.hit }</td>
		           </tr>
		           <c:set var="count" value="${count-1 }"/>
	         	</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>