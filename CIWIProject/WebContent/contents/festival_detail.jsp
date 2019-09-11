<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		var fno = ${fvo.fno};
		$('#jjim').click(function() {
			$.ajax({type : 'post',
						url : '../contents/festival_jjim_ok.do',
										data : {
											fno : fno
										},
										success : function(res) {
											location.href = '../contents/festival_detail.do?fno='
													+ fno;
										}
									})
						})
						var rating = '';
 		var rText = '';		
		if(${tCheck==true}){
			rating= '${vo.rating}';
			rtext = '${vo.rtext}';
		} 
		$('.starRev_t span').click(function() {
			var star =$(this);				
			rating = $(this).text();

			star.parent().children('span').removeClass('on');
			star.addClass('on').prevAll('span').addClass('on');
			$.ajax({
				type : 'post',
				url : '../contents/festival_review_insert.do',
				data : {
					rating : rating,
					no : '${fvo.fno}'
				},
				success : function(res) {
					alert("평점이 등록되었습니다.");
				}
			});
		});

		$('.starRev_b span').click(function() {
			$(this).parent().children('span').removeClass('on');
			$(this).addClass('on').prevAll('span').addClass('on');
			rating = $(this).text();
		});

		$('#InsertBtn').click(function() {
			var rtext = $('#rtext').val();
			$.ajax({
				type : 'post',
				url : '../contents/festival_review_insert.do',
				data : {
					rating : rating,
					rtext : rtext,
					no : '${fvo.fno}'
				},
				success : function(res) {
					/* alert(res); */
					alert("리뷰가 등록되었습니다.");
					$('#resultlist').html(res);
				}
			});
		});
		
		$('#modifiedBtn').click(function(){
			var rtext = $('#rtext').val();
			if(rating=='' || rtext==null || rtext==''){	
			}
			$.ajax({
				type : 'post',
				url : '../contents/festival_review_insert.do',
				data : {
					rating : rating,
					rtext : rtext,
					no : '${fvo.fno}'
				},
				success : function(res) {
					/* alert(res); */
					alert("리뷰가 수정되었습니다.");
					$('#resultlist').html(res);
				}
			});
				});
		$('#deleteBtn').click(function(){

			var rno = '${vo.rno}';
			var content_no = '${vo.content_no}';
			$.ajax({
				type : 'post',
				url : '../contents/festival_delete.do',
				data : {
					rno : rno,
					content_no : content_no
				},
				success : function(res) {
					/* alert(res); */
					alert("리뷰가 삭제되었습니다..");
					$('#resultlist').html(res);
				}
			});
		});
	});
</script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a254310c50d351a28bbec2eeae2161e&libraries=services"></script>
<style type="text/css">
.starR1 {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat -52px 0;
	background-size: auto 100%;
	width: 15px;
	height: 30px;
	float: left;
	text-indent: -9999px;
	cursor: pointer;
}

.starR2 {
	background:
		url('http://miuu227.godohosting.com/images/icon/ico_review.png')
		no-repeat right 0;
	background-size: auto 100%;
	width: 15px;
	height: 30px;
	float: left;
	text-indent: -9999px;
	cursor: pointer;
}

.starR1.on {
	background-position: 0 0;
}

.starR2.on {
	background-position: -15px 0;
}
</style>
</head>
<body>
	<!-- HEADER -->
	<header id="header"> <!-- PAGE HEADER -->
	<div class="page-header">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-1 col-md-10 text-center">
					<div class="author">
						<h1 class="text-uppercase">행사, 축제</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /PAGE HEADER --> </header>
	<!-- /HEADER -->
	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-sm-10">
					<h1>${fvo.subject }</h1>
				</div>
				<c:if test="${sessionScope.id==null }">
					<div class="col-sm-1">
						<a href="../member/login.do"> <input type="button"
							class="btn btn-sm btn-warning" value="로그인 필요">
						</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.id!=null }">
					<div class="col-sm-1">
						<c:if test="${flag==0 }">
							<input type="button" class="btn btn-sm btn-warning" id="jjim"
								value="보고싶어요">
						</c:if>
						<c:if test="${flag!=0 }">
							<input type="button" class="btn btn-sm btn-danger" id="jjim"
								value="등록 취소">
						</c:if>
					</div>
				</c:if>
				<div class="col-sm-1">
					<a href="../contents/festival.do" class="btn btn-sm btn-danger">목록</a>
				</div>
				<table class="table">
					<tr>
						<td rowspan=4><img src="${fvo.poster }" width=350 height=350></td>
						<th>기간</th>
						<td>${fvo.fdate }</td>
					</tr>
					<tr>
						<th>장소</th>
						<td id="address" data-address="${fvo.address}">${fvo.place }</td>
					</tr>
					<tr>
						<th>주최</th>
						<td>${fvo.host }</td>
					</tr>
					<tr>
						<th>문의</th>
						<td>${fvo.tel }</td>
					</tr>
				</table>
			</div>
			<div class="box box-warning">
				<div class="rating col-sm-3">
					<div class="starRev_b" style="padding-left: 30px;">
						<span class="starR1">0.5</span> <span class="starR2">1</span> <span
							class="starR1">1.5</span> <span class="starR2">2</span> <span
							class="starR1">2.5</span> <span class="starR2">3</span> <span
							class="starR1">3.5</span> <span class="starR2">4</span> <span
							class="starR1">4.5</span> <span class="starR2">5</span>
					</div>
				</div>
				<c:if test="${tCheck == false}">
					<div class="box-body" style="width: auto; height: auto;">
						<br> <br> <i class="fa fa-pencil"><span><strong>
									Review</strong></span></i>
						<form class="form-horizontal" method=post
							action="../contents/festival_review_insert.do" id="rinsertfrm">
							<div class="form-group margin">
								<div class="col-sm-10">
									<textarea class="form-control" id="rtext" row="3"
										placeholder="리뷰를 작성해주세요."></textarea>
								</div>
								<div class="col-sm-2">
									<button type="button"
										class="btn btn-primary btn-block replyAddBtn"
										style="height: 54px;" id="InsertBtn">
										<i class="fa fa-save"></i>등록
									</button>
								</div>
							</div>
						</form>
					</div>
				</c:if>
				<c:if test="${tCheck == true}">
					<div class="box-body" style="width: auto; height: auto;">
						<br> <br> <i class="fa fa-pencil"><span><strong>
									Review</strong></span></i>
						<form class="form-horizontal" method=post
							action="../contents/fesitval_review_insert.do" id="rinsertfrm">
							<div class="form-group margin">
								<div class="col-sm-10">
									<textarea class="form-control" id="rtext" row="3">${vo.rtext }</textarea>
								</div>
								<div class="col-sm-2">
									<button type="button"
										class="btn btn-primary btn-block replyAddBtn"
										style="height: 54px;" id="modifiedBtn">
										<i class="fa fa-save"></i>수정
									</button>
									<button type="button"
										class="btn btn-primary btn-block replyAddBtn"
										style="height: 54px;" id="deleteBtn">
										<i class="fa fa-save"></i>삭제
									</button>
								</div>
							</div>
						</form>
					</div>
				</c:if>
				<div class="box-footer">
					<form id="reviewListfrm" name="reviewList" method="post">
						<div class="reviewList text-center" id="resultlist">
							<c:forEach var="vo" items="${ rlist}">
								<tr>
									<td>${vo.memid}</td>
									<td>${vo.rating}</td>
								</tr>
							</c:forEach>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /container -->
		<%--             <table>
         <tr>
            <c:forEach var="vo" items="${list }">
               <td>${vo.rating}</td>
            </c:forEach>
         </tr>
      </table> --%>
	</div>
	<!-- /SECTION -->


	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>