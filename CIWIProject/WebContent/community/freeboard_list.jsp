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
   width:1100px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function () {
	$('#findBtn').click(function () {
		var ss=$('#ss').val();
		if(ss.trim()==""){
			$('#ss').focus();
			return;
		}
		$('#frm').submit();
	})
});
</script>
</head>
<body>
   <div class="container">
     <div class="row">
       <h1 class="text-center" style="padding: 2ex;" >자유게시판</h1>
       <table class="table">
         <tr>
           <td class="text-left">
	           <c:if test="${id!=null }">
	             <a href="freeboard_insert.do" class="btn btn-sm btn-info">새글</a>
	           </c:if>
	           <c:if test="${id==null }">
	           	글쓰기는 로그인후 이용 가능합니다.
	           </c:if>
           </td>
           <td class="text-right">
             <strong style="background-color: pink">${curpage } page / ${totalpage } pages</strong>
           </td>
         </tr>
       </table>
       <table class="table">
         <tr class="info">
          <th width=10% class="text-center"></th>
          <th width=45% class="text-center">제목</th>
          <th width=15% class="text-center">작성자</th>
          <th width=20% class="text-center">작성일</th>
          <th width=10% class="text-center">조회수</th>
         </tr>
       		<c:if test="${curpage==1 }">
		 	 <c:forEach var="gvo" items="${nList }">
			   <c:if test="${gvo.bccate=='공지사항' }">
				  <tr bgcolor="f200f200f200">
		             <td width=10% class="text-center"><strong style="color: red">공지</strong></td>
		             <td width=45% class="text-left"><a href="freeboard_detail.do?no=${gvo.no }&page=${curpage }">
		             <font color="red">[${gvo.bccate}]&nbsp; ${gvo.subject }</font></a>
		             	<c:if test="${today==gvo.dbday }">
		             		<sup><font color=pink>new</font></sup>
		             	</c:if>
		             	<c:if test="${gvo.hit>30 }">
		             		<sup><font color=red>hot</font></sup>
		             	</c:if>
		             </td>
		             <td width=15% class="text-center">${gvo.id }</td>
		             <td width=20% class="text-center">${gvo.dbday }</td>
		             <td width=10% class="text-center">${gvo.hit }</td>
		           </tr>
			  	</c:if>
			  </c:forEach>
			</c:if>
         <c:set var="count" value="${count }"/>
         <c:forEach var="vo" items="${list }" varStatus="s">
	           <tr>
	             <td width=10% class="text-center">${count }</td>
	             <td width=45% class="text-left"><a href="freeboard_detail.do?no=${vo.no }&page=${curpage }">
	             <font color="blue">[${vo.bccate}]</font>&nbsp;&nbsp; ${vo.subject }</a>
	             	<c:if test="${today==vo.dbday }">
	             		<sup><font color=pink>new</font></sup>
	             	</c:if>
	             	<c:if test="${vo.hit>30 }">
		             	<sup><font color=red>hot</font></sup>
		            </c:if>
	             </td>
	             <td width=15% class="text-center">${vo.id }</td>
	             <td width=20% class="text-center">${vo.dbday }</td>
	             <td width=10% class="text-center">${vo.hit }</td>
	           </tr>
	           <c:set var="count" value="${count-1 }"/>
         </c:forEach>
       </table>
       <table class="table">
        <tr>
        	<td class="text-center">
        		<form method="post" action="freeboard_find.do" id = "frm">
        		게시글 검색:
        		<select name="fs" class="input-sm">
        			<option value="id">아이디</option>
        			<option value="subject">제목</option>
        			<option value="content">내용</option>
        		</select>
        		<input type="text" name="ss" size="100" class="input-sm" id="ss"> 
        		<input type="button" value="검색" class="btn btn-sm btn-info" id="findBtn"> 
        		</form>
        	</td>
        </tr>
        <tr>
          <td class="text-center">
            <ul class="pagination">
              <li><a href="freeboard_list.do?page=1">&lt;&lt;</a></li>
              <li><a href="#">&lt;</a></li>
			  <c:forEach var="i" begin="1" end="${totalpage }">
			    <li class="${i==curpage?'active':''}"><a href="freeboard_list.do?page=${i }">${i }</a>
			  </c:forEach>
			  <li><a href="#">&gt;</a></li>
			  <li><a href="freeboard_list.do?page=${totalpage }">&gt;&gt;</a></li>
			</ul>
          </td>
        </tr>
       </table>
		</div>
     </div>
</body>
</html>
