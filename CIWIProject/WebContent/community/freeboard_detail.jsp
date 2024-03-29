<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="../main_css/bootstrap.min.css">
<style type="text/css">
.row {
   margin: 0px auto;
   width:1100px;
}
</style>
<script type="text/javascript">
var i=0;
var u=0;
$(function(){
	$('.replyBtn').click(function(){
		var no=$(this).attr("value");
		$('.reply').hide();
		$('.update').hide();
		if(i==0)
		{
			$('#m'+no).show();
			i=1;
		}
		else
		{
			$('#m'+no).hide();
			i=0;
		}
		
	});
	$('.updateBtn').click(function(){
		var no=$(this).attr("value");
		$('.update').hide();
		$('.reply').hide();
		if(u==0)
		{
			$('#u'+no).show();
			u=1;
		}
		else
		{
			$('#u'+no).hide();
			u=0;
		}
		
	});
});
</script>
</head>
<body>
  <%--
        내용보기  ==> list.jsp ===> DetailModel ===> detail.jsp
   --%>
  <div class="container">
    <h2 class="text-center" style="padding: 2ex;">내용보기</h2>
    <div class="row">
      <table class="table">
        <tr>
          <th class="text-center info" width=20%>번호</th>
          <td class="text-center" width=30%>${vo.no }</td>
          <th class="text-center info" width=20%>작성일</th>
          <td class="text-center" width=30%>
            ${vo.dbday }
            <%-- <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/> --%>
          </td>
        </tr>
        <tr>
          <th class="text-center info" width=20%>작성자</th>
          <td class="text-center" width=30%>${vo.id }</td>
          <th class="text-center info" width=20%>조회수</th>
          <td class="text-center" width=30%>${vo.hit }</td>
        </tr>
        <tr>
          <th class="text-center info" width=20%>제목</th>
          <td class="text-left" colspan="3">
          <font color="blue">[${vo.bccate}]</font>&nbsp;
          <font style="font-size: large;">${vo.subject }</font></td>
        </tr>
        <tr>
        	<%-- <td colspan="4" class="text-left" valign="top" height="250">
        		<textarea rows="10" cols="150" readonly="readonly">${vo.content }</textarea>
        	</td> --%>
          <td colspan="4" class="text-left" valign="top" height="200">
          <pre style="white-space: pre-line;border: none; background-color: white; font-size: 13pt; font-family: fantasy;">${vo.content }</pre></td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
	          <c:if test="${vo.id==id }">
	            <a href="freeboard_update.do?no=${vo.no }&page=${curpage}" class="btn btn-sm btn-info">수정</a>
	            <a href="freeboard_delete.do?no=${vo.no }" class="btn btn-sm btn-danger">삭제</a>
	          </c:if>
            <a href="freeboard_list.do?page=${curpage }" class="btn btn-sm btn-info">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div class="row">
      <table class="table">
        <tr>
         <td class="text-left">댓글(${count })</td>
        </tr>
      </table>
      <table class="table">
        <c:forEach var="rvo" items="${list }">
          
          <table class="table">
           <tr>
             <td class="text-left">
             <c:if test="${rvo.group_tab>0 }">
	            <c:forEach var="i" begin="1" end="${rvo.group_tab }">
	              &nbsp;&nbsp;
	            </c:forEach>
	            └
	          </c:if>
                               ▶<font color="blue">${rvo.id }</font>&nbsp;${rvo.dbday }</td>
             <td class="text-right">
              <c:if test="${sessionScope.id!=null && sessionScope.id==rvo.id }">
               <a href="#" class="btn btn-xs btn-warning updateBtn" value="${rvo.no }">수정</a>
               <a href="../community/reply_delete.do?no=${rvo.no }&bno=${vo.no}&page=${curpage}" class="btn btn-xs btn-info">삭제</a>
              </c:if>
              <c:if test="${sessionScope.id!=null }">
               <a href="#" class="btn btn-xs btn-success replyBtn" value="${rvo.no }">댓글</a>
              </c:if>
             </td>
           </tr>
           <tr>
             <td class="text-left" colspan="2">
             <c:if test="${rvo.group_tab>0 }">
	            <c:forEach var="i" begin="1" end="${rvo.group_tab }">
	              &nbsp;&nbsp;
	            </c:forEach>
	          </c:if>
             <pre style="white-space: pre-line;">${rvo.msg }</pre></td>
           </tr>
           <tr style="display:none" id="m${rvo.no }" class="reply">
	          <td class="text-left" colspan="2">
	           <form name="frm" method="post" action="../community/reply_reinsert.do">
	            <textarea rows="3" cols="100" name="msg" style="float: left"></textarea>
	            <input type="hidden" name="bno" value="${vo.no }">
	            <input type="hidden" name=no value="${rvo.no }">
	            <input type="hidden" name="page" value="${curpage }">
	            <input type="submit" class="btn btn-sm btn-primary" style="height: 67px"
	             value="RE 댓글쓰기"
	            >
	           </form>
	          </td>
	        </tr>
	        <tr style="display:none" id="u${rvo.no }" class="update">
	          <td class="text-left" colspan="2">
	           <form name="frm" method="post" action="../community/reply_update.do">
	            <textarea rows="3" cols="100" name="msg" style="float: left">${rvo.msg }</textarea>
	            <input type="hidden" name="bno" value="${vo.no }">
	            <input type="hidden" name=no value="${rvo.no }">
	            <input type="hidden" name="page" value="${curpage }">
	            <input type="submit" class="btn btn-sm btn-primary" style="height: 67px"
	             value="수정하기"
	            >
	           </form>
	          </td>
	        </tr>
          </table>
        </c:forEach>
      </table>
      <c:if test="${sessionScope.id!=null }">
	      <table class="table">
	        <tr>
	          <td class="text-left">
	           <form name="frm" method="post" action="../community/reply_insert.do">
	            <textarea rows="3" cols="130" name="msg" style="float: left"></textarea>
	            <input type="hidden" name="bno" value="${vo.no }">
	            <input type="hidden" name="page" value="${curpage }">
	            <input type="submit" class="btn btn-sm btn-primary" style="height: 64px"
	             value="댓글쓰기"
	            >
	           </form>
	          </td>
	        </tr>
	      </table>
      </c:if>
    </div>
  </div>
</body>
</html>