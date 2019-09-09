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
		    <c:if test="${ id!=null && admin==1 }">
			  <table class="table" frame=void>
		         <tr>
		           <td class="text-left">
			             <a href="noticeboard_insert.do" class="btn btn-sm btn-info">공지 쓰기</a>
		           </td>
		         </tr>
		       </table>
		    </c:if>
		<div style="height: auto; width: 100%; border:2px solid gold;">
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
		             <td width=15% class="text-center">관리자</td>
		             <td width=20% class="text-center">${vo.dbday }</td>
		             <td width=10% class="text-center">${vo.hit }</td>
		           </tr>
		           <c:set var="count" value="${count-1 }"/>
	         	</c:forEach>
			</table>
		</div>
			<table class="table">
				<tr>
		          <td class="text-center">
		            <ul class="pagination">
			          <c:if test="${curpage>BLOCK }">
			             <li><a href="noticeboard_list.do?page=1">&lt;&lt;</a></li>
			             <li><a href="noticeboard_list.do?page=${startPage-1 }">&lt;</a></li>
			          </c:if>
					  <c:forEach var="i" begin="${startPage }" end="${endPage }">
					    <li class="${i==curpage?'active':''}"><a href="noticeboard_list.do?page=${i }">${i }</a>
					  </c:forEach>
					  <c:if test="${endPage<allPage }">
						 <li><a href="noticeboard_list.do?page=${endPage+1 }">&gt;</a></li>
						 <li><a href="noticeboard_list.do?page=${allPage}">&gt;&gt;</a></li>
					  </c:if>
					</ul>
		          </td>
		        </tr>
			</table>
		</div>
	</div>
</body>
</html>