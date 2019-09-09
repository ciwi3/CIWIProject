<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="../main_css/s_style">
<link rel="../main_css/main_style">
<script type="text/javascript">
$('.starRev span').click(function(){
    $(this).parent().children('span').removeClass('on');
    $(this).addClass('on').prevAll('span').addClass('on');
    return false;
  });
</script>

<script type="text/javascript">
	$(function(){
		var sno = ${svo.sno};
		$('#jjim').click(function() {
			$.ajax({
				type : 'post',
				url : '../contents/show_jjim_ok.do',
				data : {sno:sno},
				success : function(res) {
					location.href = '../contents/show_detail.do?no=' + sno;
				}
			})
		})
	})
</script>
<style type="text/css">
.starR1{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat -52px 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR2{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
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
						<h1 class="text-uppercase">공연／전시</h1>
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
			<div class="row"
				style="margin-top: 30px; margin-left: 45px; margin-right: 45px;">
				<div class="col-sm-10">
					<h3 style="font: bold;">${svo.subject }</h3>
				</div>
				<c:if test="${sessionScope.id==null }">
				<div class="col-sm-1">
					<a href="../member/login.do">
						<input type="button" class="btn btn-sm btn-warning" value="로그인 필요">
					</a>
				</div>
				</c:if>
				<c:if test="${sessionScope.id!=null }">
					<div class="col-sm-1">
					<c:if test="${flag==0 }">
						<input type="button" class="btn btn-sm btn-warning" id="jjim" value="보고싶어요">
					</c:if>
					<c:if test="${flag!=0 }">
						<input type="button" class="btn btn-sm btn-danger" id="jjim" value="등록 취소">
					</c:if>
					</div>
				</c:if>
				<div class="col-sm-1">
					<a href="../contents/show.do" class="btn btn-sm btn-danger">목록</a>
				</div>
				<table class="table">
					<tr>
						<td rowspan=2><img src="${svo.poster }" width=350px
							height=450px></td>
						<th>공연기간</th>
						<td>${svo.sdate }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${svo.place }</td>
					</tr>
					<tr>
						<th>공연가격</th>
						<td>${svo.price }</td>
					</tr>
					<tr>
						<th>공연장소</th>
						<td>${svo.place }</td>
					</tr>
					<tr>
						<th>관람시간</th>
						<td>${svo.showtime }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${svo.tel }</td>
					</tr>
					<tr>
						<th>주최</th>
						<td>${svo.host }</td>
					</tr>
					<tr>
						<th>연령</th>
						<td>${svo.age}</td>
					</tr>
					<tr>
						<th>출처</th>
						<td>${svo.source}</td>
					</tr>
				</table>
			</div>
			<!-- /row -->
			<div class="box box-warning">
            <div class="rating col-sm-3">
               <div class="starRev" style="padding-left:30px;">
                  <span class="starR1 on">0.5</span> <span class="starR2">1</span> <span
                     class="starR1">1.5</span> <span class="starR2">2</span> <span
                     class="starR1">2.5</span> <span class="starR2">3</span> <span
                     class="starR1">3.5</span> <span class="starR2">4</span> <span
                     class="starR1">4.5</span> <span class="starR2">5</span>
               </div>
            </div>
            <div class="box-body" style="width: auto; height: auto;">
               <br>
               <br> <i class="fa fa-pencil"><span><strong> Review</strong></span></i>
               <form class="form-horizontal" method=post
                  action="../contents/show_review_insert.do" id="rinsertfrm">
                  <div class="form-group margin">
                     <div class="col-sm-10">
                        <textarea class="form-control" id="rtext" row="3"
                           placeholder="리뷰를 작성해주세요."></textarea>
                     </div>
                     <div class="col-sm-2">
                        <button type="button"
                           class="btn btn-primary btn-block replyAddBtn" style="margin-top:11px;" id="InsertBtn">
                           <i class="fa fa-save"></i>등록
                        </button>
                     </div>
                  </div>
               </form>
            </div>
            <div class="box-footer">
               <form id="reviewListfrm" name="reviewList" method="post">
                  <div class="reviewList text-center">
                     <ul class="pagination pagination-sm no-margin">

                     </ul>
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

</body>
</html>