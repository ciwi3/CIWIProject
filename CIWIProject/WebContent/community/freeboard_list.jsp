<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../main/css/bootstrap.min.css">
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
       <h1 class="text-center">자유게시판</h1>
       <table class="table">
         <tr>
           <td class="text-left">
             <a href="freeboard_insert.do" class="btn btn-sm btn-info">새글</a>
           </td>
           <td class="text-right">
            <font color="f1f1f1"> ${curpage } page / ${totalpage } pages</font>
           </td>
         </tr>
       </table>
       <table class="table">
         <tr class="info">
          <th width=10% class="text-center">번호</th>

          <th width=45% class="text-left">
          					<select name="board_category">
								<option>글머리 선택 </option>
								<option>잡담</option>
								<option>질문</option>
								<option>정보공유</option>
								<option>공지사항</option>
							</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;제목</th>
          <th width=15% class="text-center">아이디</th>
          <th width=20% class="text-center">작성일</th>
          <th width=10% class="text-center">조회수</th>
         </tr>
		  <c:forEach var="gvo" items="${list }" varStatus="s">
		  	<c:if test="${gvo.bccate=='공지사항' }">
			  	<tr bgcolor="pink">
	             <td width=10% class="text-center">공지</td>
	             <td width=45% class="text-left"><a href="freeboard_detail.do?no=${gvo.no }">
	             <font color="red">[${gvo.bccate}]</font>&nbsp; ${gvo.subject }</a>
	             	<c:if test="${today==gvo.dbday }">
	             		<sup><font color=red>new</font></sup>
	             	</c:if>
	             </td>
	             <td width=15% class="text-center">${gvo.id }</td>
	             <td width=20% class="text-center">${gvo.dbday }</td>
	             <td width=10% class="text-center">${gvo.hit }</td>
	           </tr>
		  	</c:if>
		  </c:forEach>
         <c:forEach var="vo" items="${list }" varStatus="s">
        	 <c:if test="${gvo.bccate!='공지사항' }">
	           <tr class="${s.index%2==0?'':'warning' }">
	             <td width=10% class="text-center">${vo.no }</td>
	             <td width=45% class="text-left"><a href="freeboard_detail.do?no=${vo.no }">
	             <font color="blue">[${vo.bccate}]</font>&nbsp;&nbsp; ${vo.subject }</a>
	             	<c:if test="${today==vo.dbday }">
	             		<sup><font color=red>new</font></sup>
	             	</c:if>
	             </td>
	             <td width=15% class="text-center">${vo.id }</td>
	             <td width=20% class="text-center">${vo.dbday }</td>
	             <td width=10% class="text-center">${vo.hit }</td>
	           </tr>
         	</c:if>
         </c:forEach>
       </table>
       <table class="table">
        <tr>
        	<td class="text-center">
        		<form method="post" action="find.do" id = "frm">
        		게시글 검색:
        		<select name="fs" class="input-sm">
        			<option value="name">아이디</option>
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








