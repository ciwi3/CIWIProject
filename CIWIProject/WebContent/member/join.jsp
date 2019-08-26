<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center">회원가입</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th class="text-right" width=20%>ID</th>
					<td class="text-left" width=80%>
						<input type=text name=id class="input-sm" size=15>
						<input type=button class="btn btn-sm btn-primary" value=중복체크>
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>Password</th>
					<td class="text-left" width=80%>
						<input type=password name=pwd class="input-sm" size=15>
						<input type=password name=pwd1 class="input-sm" size=15 placeholder="재입력">
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>이름</th>
					<td class="text-left" width=80%>
						<input type=text name=name class="input-sm" size=15>
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>성별</th>
					<td class="text-left" width=80%>
						<input type=radio value="남자" name=sex checked="checked"> 남자
						<input type=radio value="여자" name=sex> 여자
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>우편번호</th>
					<td class="text-left" width=80%>
						<input type=text name=post1 class="input-sm" size=15 readonly="readonly"> - 
						<input type=text name=post2 class="input-sm" size=15 readonly="readonly">
						<input type=button class="btn btn-sm btn-primary" value=검색>
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>주소</th>
					<td class="text-left" width=80%>
						<input type=text name=addr1 class="input-sm" size=55>
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>상세주소</th>
					<td class="text-left" width=80%>
						<input type=text name=addr2 class="input-sm" size=55>
					</td>
				</tr>
				<tr>
					<th class="text-right" width=20%>전화번호</th>
					<td class="text-left" width=80%>
						<select name=tel1 class="input-sm">
							<option>010</option>
							<option>011</option>
							<option>017</option>
						</select> - 
						<input type=text name=tel2 class="input-sm" size=7> - 
						<input type=text name=tel3 class="input-sm" size=7>
					</td>
				</tr>
				<tr>
					<td colspan=2 class="text-center">
						<input type=submit value=가입 class="btn btn-sm btn-success">
						<input type=button value=취소 class="btn btn-sm btn-danger" onclick="javascript:history.back()">
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>