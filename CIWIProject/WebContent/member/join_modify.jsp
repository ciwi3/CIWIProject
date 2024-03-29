<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>CIWI Template</title>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- 다음 우편검색 -->
<script type="text/javascript">
$(function(){
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
		$('#modifyBtn').click(function(){
				var pwd=$('#pwd').val();
				var post=$('#post').val(); 
				var main_addr=$('#main_addr').val();
				var sub_addr=$('#sub_addr').val();
				var email1=$('#email1').val();
				var email2=$('#email2').val();
				var phone1=$("#phone1 option:selected").val();
				var phone2=$('#phone2').val();
				var phone3=$('#phone3').val();
				if(pwd.trim()==""){
					$('#pwd').focus();
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
				if(email1.trim()==""){
					$('#email1').focus();
					return;
				}
				if(email2.trim()==""){
					$('#email2').focus();
					return;
				}
				if(phone1.trim()=="번호선택"){
					alert("휴대폰번호 확인해주세요.");
					$('#phone1').focus();
					return;
				}
				if(phone2.trim()==""){
					$('#phone2').focus();
					return;
				}
				if(phone3.trim()==""){
					$('#phone3').focus();
					return;
				}
				var cate1=$("#cate1 option:selected").val();
				if(cate1.trim()=="카테고리선택"){
					cate1=null;
				}
				var cate2=$("#cate2 option:selected").val();
				if(cate2.trim()=="카테고리선택"){
					cate2=null;
				}
				var genre1=$("#genre1 option:selected").val();
				if(genre1.trim()=="장르선택"){
					genre1=null;
				}
				var genre2=$("#genre2 option:selected").val();
				if(genre2.trim()=="장르선택"){
					genre2=null;
				}
				
				$.ajax({
					type:'post',
					url:'../member/join_modify_ok.do',
					data:{pwd:pwd,email1:email1,email2:email2,
							phone1:phone1,phone2:phone2,phone3:phone3,post:post,main_addr:main_addr,
							sub_addr:sub_addr,cate1:cate1,cate2:cate2,genre1:genre1,genre2:genre2},
					success:function(res){
						location.href="../member/modify_finish.do"; //이동화면
					}
			});// ajax
		});//회원가입완료버튼
		//회원탈퇴
		$('#deleteBtn').click(function(){ 
				var pwd=$('#pwd').val();// 입력한 아이디 조건
						if(pwd.trim()==""){
							$('#pwd').focus();
							alert("탈퇴 하시려면 비밀번호를 입력해주세요.");
							return;
						}
							$.ajax({
							type:'post',
							url:'../member/member_delete.do',
							data:{pwd:pwd},
							success:function(response){
								alert("정상 탈퇴되었습니다. 안녕히 가세요.");
								location.href="../main/main.do";
								}
						}); 
			}); // 비밀번호중복체크 
});
//다음우편검색 
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('post').value = data.zonecode;
            document.getElementById("main_addr").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sub_addr").focus();
        }
    }).open();
}
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
			<h2 class="text-center">회원정보 수정</h2>
				<div class="row">
					<form method=post action="../member/join_modify_ok.do">
					<table class="table">
						<tr>
							<th class="text-right" width=20% height=20%><font size="2px">아이디</font></th>
							<td class="text-left" width=80%>
								<input type=text name=id size=20 id="id" readonly value="${id }">
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
								<input type=text name=name size=15 id=name value="${name }" readonly="readonly">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">우편번호</font></th>
								<td>
									<input type="text" id="post" placeholder=" 우편번호" value="${post }" width=80% name=post >
									<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
								</td>
						</tr>
						<tr>
							<th class="text-right" width=20%><font size="2px">주소</font></th>
							<td class="text-left" width=80% >
								<input type="text" id="main_addr" placeholder=" 주소" value="${main_addr }" size=40 name="main_addr" ><br>
								<input type="text" id="sub_addr" placeholder=" 상세주소" value="${sub_addr }" name="sub_addr">
								<input type="text" id="sample6_extraAddress" placeholder=" 참고항목">
							</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">Email</font></th>
								<td class="text-left" width=80% name=email id=email>
									<input type=text size=10 name=email1 id=email1 > @
									<input type=text size=15 name=email2 id=email2>
								</td>
						</tr>
						<tr>
							<th class="text-right" width=20% ><font size="2px">연락처</font></th>
							<td class="text-left" width=80% name=phone id=phone>
								<select name=phone1 id=phone1>
									<option>번호선택</option>
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
								</select> - 
								<input type=text  size=5 name=phone2 id=phone2> - 
								<input type=text  size=5 name=phone3 id=phone3>
							</td>
						</tr>
							<tr>
							<th class="text-right" width=20%><font size="2px">보고싶어요 장르</font>
								<td class="text-left" width=80%>
								<select name=cate id=cate1>
									<option>카테고리선택</option>
										<option>영화</option>
										<option>공연 전시</option>
										<option>페스티벌</option>
								</select>
								<select name=genre id=genre1>
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
								<select name=cate id=cate2>
									<option>카테고리선택</option>
									<option>영화</option>
									<option>공연 전시</option>
									<option>페스티벌</option>
								</select>
								<select name=genre id=genre2>
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
                  					<input type=button value="수정취소" class="btn btn-ms btn-danger" onclick="javascript:history.back()">
               						<input type=button class="btn btn-ms btn-info" value="정보수정" id=modifyBtn>
               				</td>
               				<td colspan=18 class="text-right">
               						<input type=button class="btn btn-sm btn-danger" value="회원탈퇴" id=deleteBtn>
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