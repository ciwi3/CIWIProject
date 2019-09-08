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
$(function(){
	var fno=${fvo.fno};
	$('#jjim').click(function(){
		$.ajax({
			type:'post',
			url:'../contents/festival_jjim_ok.do',
			data:{fno:fno},
			success:function(res) {
				location.href='../contents/festival_detail.do?fno='+fno;
			}
		})
	})
})
</script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a254310c50d351a28bbec2eeae2161e&libraries=services"></script>
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
					<a href="../member/login.do">
						<input type="button" class="btn btn-sm btn-warning" value="로그인 필요">
					</a>
				</div>
				</c:if>
				<c:if test="${sessionScope.id!=null }">
				<div class="col-sm-1">
					<input type="button" class="btn btn-sm btn-warning" id="jjim" value="보고싶어요">
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
			<div id="map" style="width: 500px; height: 400px;"></div>

		</div>
		<!-- /row -->
		<script type="text/javascript"
			src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0a254310c50d351a28bbec2eeae2161e"></script>
		<script>
			var address = $('#address').attr("data-address");
			if (address != '-') {
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					level : 2,
					// 지도의 확대 레벨
					draggable : false
				};

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption);

				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();

				// 주소로 좌표를 검색합니다
				geocoder
						.addressSearch(
								address,
								function(result, status) {

									// 정상적으로 검색이 완료됐으면 
									if (status === kakao.maps.services.Status.OK) {

										var coords = new kakao.maps.LatLng(
												result[0].y, result[0].x);

										// 결과값으로 받은 위치를 마커로 표시합니다
										var marker = new kakao.maps.Marker({
											map : map,
											position : coords
										});

										// 인포윈도우로 장소에 대한 설명을 표시합니다
										var infowindow = new kakao.maps.InfoWindow(
												{
													content : '<div style="width:300px;text-align:center;padding:6px 0;">'+address+'</div>'
												});
										infowindow.open(map, marker);

										// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
										map.setCenter(coords);
									}
								});
			} else {
				$('#map').css("display", "none");
			}
		</script>
		<!-- /container -->
	</div>
	<!-- /SECTION -->


	<!-- jQuery Plugins -->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.stellar.min.js"></script>
	<script src="../js/main.js"></script>
</body>
</html>