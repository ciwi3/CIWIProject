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
</head>
<body>
   <div class="container">
     <div class="row">
       <h2 class="text-center">검색결과</h2>
       <c:if test="${count==0 }">
	       <table class="table">
	       	<tr>
	       		<td class="text-center">검색 결과가 없습니다.</td>
	       	</tr>
	       </table>
       </c:if>
       <c:if test="${count>0 }">
	       <table class="table">
	         <tr class="info">
	          <th width=10% class="text-center">번호</th>
	          <th width=45% class="text-center">제목</th>
	          <th width=15% class="text-center">아이디</th>
	          <th width=20% class="text-center">작성일</th>
	          <th width=10% class="text-center">조회수</th>
	         </tr>
	         <c:forEach var="vo" items="${list }" varStatus="s">
	           <tr>
	             <td width=10% class="text-center">${vo.no }</td>
	             <td width=45% class="text-left"><a href="freeboard_detail.do?no=${vo.no }">
	             <font color="blue">[${vo.bccate}]</font>&nbsp;&nbsp;${vo.subject }</a></td>
	             <td width=15% class="text-center">${vo.id }</td>
	             <td width=20% class="text-center">${vo.dbday }</td>
	             <td width=10% class="text-center">${vo.hit }</td>
	           </tr>
	         </c:forEach>
	       </table>
       </c:if>
       <table class="table">
         <tr>
           <td class="text-right">
             <a href="freeboard_list.do" class="btn btn-sm btn-info">목록</a>
           </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>