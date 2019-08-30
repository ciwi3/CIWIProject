<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>CIWI Template</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	//회원가입 완료버튼 눌렀을때
	$('#overlapIDBtn').click(function(){ 
		var id=$('#id').val();// 입력한 아이디 조건
				if(id.trim()=="" ||  id.length<4 ){
					$('#idConditon').text("4~16자이내로 입력하세요.");
					$('#idConditon').css("color","red");
					$('#id').focus();
					return;
				}else if (id.length>16){
					$('#idConditon').text("4~16자이내로 입력하세요.");
					$('#idConditon').css("color","red");
					$('#id').focus();
					return;
				}
		 		$.ajax({
					type:'post',
					url:'../member/join_ok.do',
					data:{id:id},
					success:function(response){
						var count = response.trim();
						if(count ==1){
							$('#idConditon').text("사용 중인 아이디입니다. 다시입력해주세요.");
							$('#idConditon').css("color","red");
							$('#idConditon').focus();
							return;
						}else if(count ==0){
							$('#idConditon').text("사용 가능한 아이디입니다.");
							$('#idConditon').css("color","blue");
						}
					}
				}); 
	}); // 아이디중복체크 
	$('#overlapPWDBtn').click(function(){
				var pwd=$('#pwd').val();// 입력한 비밀번호 조건
				if(pwd.trim()=="" ||  pwd.length<6 ){
					$('#pwdCondition').text("영문 대/소문자+숫자 조합, 6~16자로 입력하세요.");
					$('#pwdCondition').css("color","red");
					$('#pwd').focus();
					return;
				}else if (pwd.length>16){
					$('#pwdCondition').text("영문 대/소문자+숫자 조합, 6~16자로 입력하세요.");
					$('#pwdCondition').css("color","red");
					$('#pwd').focus();
					return;
				} else if (!pwd.match(/[0-9]+[a-z]|[A-Z]/)){
					$('#pwdCondition').text("영문 대/소문자+숫자 조합, 6~16자로 입력하세요.");
					$('#pwdCondition').css("color","red");
					$('#pwd').focus();
					return;
				}else{
					$('#pwdCondition').text("사용가능한 비밀번호입니다.");
					$('#pwdCondition').css("color","blue");
					return;
				}
	});//비밀번호 확인
	$('#joinBtn').click(function(){
		var id=$('#id').val();
		var pwd=$('#pwd').val();
		var name=$('#name').val();
		var birth=$('#birth').val();
		var sex=$('#sex').val();
		var post=$('#post').val();
		var main_addr=$('#main_addr').val();
		var sub_addr=$('#sub_addr').val();
		var email=$('#email').text();
		var phone=$('#phone').text();
		if(id.trim()==""){
			$('#id').focus();
			return;
		}
		if(pwd.trim()==""){
			$('#pwd').focus();
			return;
		}
		if(name.trim()==""){
			$('#name').focus();
			return;
		}
		if(birth.trim()==""){
			$('#birth').focus();
			return;
		}
		if(post.trim()==""){
			$('#post').focus();
			return;
		}
		if(main_addr.trim()==""){
			$('#main_addr').focus();
			return;
		}
		if(sub_addr.trim()==""){
			$('#sub_addr').focus();
			return;
		}
		if(email.trim()==""){
			$('#email').focus();
			return;
		}
		if(phone.trim()==""){
			$('#phone').focus();
			return;
		}
		$('form').submit();
	});
});//마지막
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
					<form method=post action="../member/insert.do">
					<table class="table">
						<tr>
							<th class="text-right" width=20% height=20%><font size="2px">아이디</font></th>
							<td class="text-left" width=80%>
								<input type=text name=id size=20 id="id">
								<input type=button value="중복확인" class="btn btn-sm btn-info" id="overlapIDBtn" >
								&nbsp;&nbsp;
								<font size="2px" id="idConditon">영문소문자/숫자, 4~16자</font>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">비밀번호</font></th>
							<td class="text-left" width=80%>
								<input type=password name=pwd size=25 id="pwd">
								<input type=button  value="비밀번호확인" class="btn btn-sm btn-info" id="overlapPWDBtn">&nbsp;&nbsp;
								<font size="2px" id="pwdCondition">영문 대/소문자+숫자 조합, 6~16자</font>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">이름</font></th>
							<td class="text-left" width=80%>
								<input type=text name=name size=15 id=name>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">생년월일</font></th>
							<td class="text-left" width=80%>
								<input type="date" size=20 name=birth id=birth>
								<%-- <select name=birth >
								<!-- forEach돌려서 생년월일 하기.  -->
								<c:forEach var="i" begin="1900" end="2020" >
									<c:if test="${i==2010 }">
									<option selected>${i }</option>
									</c:if>
									<c:if test="${i!=2010 }">
									<option>${i }</option>
									</c:if>
									</c:forEach>
								</select>&nbsp;&nbsp;
								<select name=birth >
									<c:forEach var="i" begin="1" end="12">
									<option>${i }</option>
									</c:forEach>
								</select>&nbsp;&nbsp;
								<select name=birth >
									<c:forEach var="i" begin="1" end="31">
									<option>${i }</option>
									</c:forEach>
								</select>--%>&nbsp;&nbsp;
								<font size="2px">음력</font>&nbsp;<input type=radio value="음력">
								<font size="2px">양력</font>&nbsp;<input type=radio value="양력" checked="checked">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">성별</font></th>
							<td class="text-left" width=80% name=sex>
								<font size="2px">남자</font>&nbsp;<input type=radio value="남자" checked="checked" id=m>&nbsp;&nbsp;
								<font size="2px">여자</font>&nbsp;<input type=radio  value="여자" id=w>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">우편번호</font></th>
							<td class="text-left" width=80% name=post>
								<input type=text size=20 id=post >
								<input type=button  value="우편번호검색" class="btn btn-sm btn-info">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20%><font size="2px">주소</font></th>
							<td class="text-left" width=80% >
								<input type=text name=main_addr size=50 id=main_addr>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20%><font size="2px">상세주소</font></th>
							<td class="text-left" width=80% >
								<input type=text name=sub_addr size=50 placeholder=" 나머지주소 입력" id=sub_addr>
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">Email</font></th>
							<td class="text-left" width=80% name=email>
								<input type=text size=10 > @
								<input type=text size=15 >
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">연락처</font></th>
							<td class="text-left" width=80% name=phone>
								<select >
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
								<select name=cate>
									<option>카테고리선택</option>
									<option>영화</option>
									<option>공연 전시</option>
									<option>페스티벌</option>
								</select>
								<select name=genre>
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
								<select name=cate>
									<option>카테고리선택</option>
									<option>영화</option>
									<option>공연 전시</option>
									<option>페스티벌</option>
								</select>
								<select name=genre>
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
               						<input type=button class="btn btn-ms btn-info" value="신규회원가입 완료" id=joinBtn>
               					</td>
							</th>
					</table>
					</form>
					</div>
				</div>
				<!-- /container -->
			</div>
</body>
</html>