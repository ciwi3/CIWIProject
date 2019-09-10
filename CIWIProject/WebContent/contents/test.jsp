<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div id="products" class="row list-group">
			<div class="item  col-xs-4 col-lg-4">
				<div class="thumbnail">
					<img class="group list-group-image"
						src="http://placehold.it/250x350/000/fff" alt="" />
					<div class="caption">
						<h4 class="group inner list-group-item-heading">${svo.subject }</h4>
						<p class="group inner list-group-item-text">
							<ul></ul>
						</p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">$21.000</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<a class="btn btn-success" href="http://www.jquery2dotnet.com">Add
									to cart</a>
							</div>
						</div>
					</div>
				</div>
			</div>
</body>
</html>