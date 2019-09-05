<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Accordion - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#accordion" ).accordion();
  } );
  </script>
<style type="text/css">
  .aco{
  margin: 0px auto;
   width:700px;
  }
</style>
</head>
<body>
<div>
<h1 class="text-center" style="padding: 2ex;"><strong>자주묻는 질문 Q & A</strong></h1>
			<c:if test="${admin==1 }">
	<table class="table text-center">
		<td>
				<a href="qnaboard_insert.do" class="btn btn-lg btn-info">Q&A추가</a>
		</td>
	</table>
			</c:if>
</div>
<div id="accordion" class="aco">
	<c:forEach var="i" items="${list }">
	  <h3>${i.subject }</h3>
	  <div>
	    <pre>${i.content }</pre>
	  </div>
	</c:forEach>
</div>
</body>
</html>









