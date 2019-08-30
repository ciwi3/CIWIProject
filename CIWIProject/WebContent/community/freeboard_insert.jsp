<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">
.row{
	margin: 0px auto;
	width:  900px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 class="text-center">글쓰기</h2>
		<div class="row">
			<form method="post" action="freeboard_insert_ok.do">
				<table class="table">
					<tr>
						<th class="text-right info" width="20%">아이디</th>
						<td width="80%" class="text-left">
							<input type="text" name="id" size="15" class="input-sm">
						</td>
					</tr>
					<tr>
					<th class="text-right info" width="20%">제목</th>
						<td width="80%" class="text-left">
							<input type="text" name="subject" size="15" class="input-sm">
						</td>
					</tr>
					<th class="text-right info" width="20%">내용</th>
						<td width="80%">
							<textarea rows="10" cols="55" name="content" ></textarea>
						</td>
					</tr>
					<th class="text-right info" width="20%">게시글 분류</th>
						<td width="80%" class="text-left">
							<select name="board_category">
								<option>1.잡담</option>
								<option>2.질문</option>
								<option>3.정보공유</option>
								<option>4.공지사항</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" value="글쓰기" class="btn btn-sm btn-info">
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