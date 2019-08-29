<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>CIWI Template</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#id').keyup(function(){
		var id=$('#id').val();
		
		
	 		$.ajax({
			type:'post',
			url:'../member/join_ok.do',
			data:{id:id},
			success:function(response){
				var count = response.trim();
				if( id.trim()=="" || (id.lenght>4 && id.lenght<16) ){
					$('#id').text("조건에 맞게 입력하셈");
					return;
				}
				if(count ==1){
					$('#a').text("사용 중인 아이디입니다. 다시입력해주세요.");
					$('#a').focus();
					return;
				}else if(count ==0){
					$('#a').text("사용 가능한 아이디입니다.");
					return;
				}
			}
		}); 
	});
});
</script>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
	<!-- SECTION -->
	<div class="section">
		<div class="container">
			<h2 class="text-center">회원가입</h2>
				<div class="row">
					<table class="table">
						<tr>
							<th class="text-right" width=20% height=20%><font size="2px">아이디</font></th>
							<td class="text-left" width=80%>
								<input type=text name=id size=20 id="id">
								<input type=button value="중복확인" class="btn btn-sm btn-info" id="overlapBtn" >
								&nbsp;&nbsp;
								<font size="2px" id=a>영문소문자/숫자, 4~16자</font>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">비밀번호</font></th>
							<td class="text-left" width=80%>
								<input type=password name=pwd size=25 >&nbsp;&nbsp;
								<font size="2px">영문 대/소문자+숫자 조합, 6~16자</font>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">이름</font></th>
							<td class="text-left" width=80%>
								<input type=text name=name size=15 >
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">생년월일</font></th>
							<td class="text-left" width=80%>
								<select name=birth >
								<!-- forEach돌려서 생년월일 하기.  -->
									<option></option>
								</select>&nbsp;&nbsp;
								<select name=birth >
									<option></option>
								</select>&nbsp;&nbsp;
								<select name=birth >
									<option></option>
								</select>&nbsp;&nbsp;
								<font size="2px">음력</font>&nbsp;<input type=radio name=month value="음력">
								<font size="2px">양력</font>&nbsp;<input type=radio name=month value="양력">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">성별</font></th>
							<td class="text-left" width=80%>
								<font size="2px">남자</font>&nbsp;<input type=radio name=sex value="남자" checked="checked">&nbsp;&nbsp;
								<font size="2px">여자</font>&nbsp;<input type=radio name=sex value="여자" >
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">우편번호</font></th>
							<td class="text-left" width=80%>
								<input type=text name=name size=20 >
								<input type=button name=post value="우편번호검색" class="btn btn-sm btn-info">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20%><font size="2px">주소</font></th>
							<td class="text-left" width=80% >
								<input type=text name=name size=50>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20%><font size="2px">상세주소</font></th>
							<td class="text-left" width=80% >
								<input type=text name=name size=50 placeholder=" 나머지주소 입력">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">Email</font></th>
							<td class="text-left" width=80%>
								<input type=text name=name size=10 > @
								<input type=text name=name size=15 >
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">연락처</font></th>
							<td class="text-left" width=80%>
								<select name=tel >
									<option>번호선택</option>
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select> - 
								<input type=text name=tel size=5 > - 
								<input type=text name=tel size=5 >
							</td>
						</tr>
							<tr>
							<th class="text-right" width=20%><font size="2px">보고싶어요 장르</font>
								<td class="text-left" width=80%>
								<select name=category>
									<option>카테고리선택</option>
									<option>영화</option>
									<option>공연 전시</option>
									<option>페스티벌</option>
								</select>
								<select name=category>
										<option>장르선택</option>
										<option>액션</option>
										<option>코미디</option>
										<option>애니매이션</option>
										<option>모험</option>
										<option>가족</option>
										<option>드라마</option>
										<option>판타지</option>
										<option>뮤지컬</option>
										<option>멜로/로멘스</option>
										<option>다큐멘터리</option>
										<option>미스터리</option>
										<option>공포</option>
										<option>SF</option>
										<option>공연실황</option>
										<option>범죄</option>
										<option>스릴러</option>
										<option>기타</option>
									</select>
								</td>
							</tr>
							<tr>
							<th class="text-right" width=20%><font size="2px">      </font>
								<td class="text-left" width=80%>
								<select name=category>
									<option>카테고리선택</option>
									<option>영화</option>
									<option>공연 전시</option>
									<option>페스티벌</option>
								</select>
								<select name=category>
										<option>장르선택</option>
										<option>액션</option>
										<option>코미디</option>
										<option>애니매이션</option>
										<option>모험</option>
										<option>가족</option>
										<option>드라마</option>
										<option>판타지</option>
										<option>뮤지컬</option>
										<option>멜로/로멘스</option>
										<option>다큐멘터리</option>
										<option>미스터리</option>
										<option>공포</option>
										<option>SF</option>
										<option>공연실황</option>
										<option>범죄</option>
										<option>스릴러</option>
										<option>기타</option>
									</select>
								</td>
							</tr>
							<td colspan=2 class="text-center">
                  					<input type=button value="가입취소" class="btn btn-ms btn-danger" onclick="javascript:history.back()">
               						<a href="../member/join_finish.do" class="btn btn-ms btn-info">신규회원가입 완료</a>
               					</td>
							</th>
					</table>
					</div>
				</div>
				<!-- /container -->
			</div>
</body>
</html>