<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Food Waste Management | Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>

<body background="static/image/background-pattern-design-87.jpg">
	<!-- NAVBAR DIV -->
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="home" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="newproduct">Post New Product</a></li>
					<li><a href="allproducts">Available Products</a></li>
				</ul>
			</div>
		</div>
	</div>


	<c:choose>
		<%-- CONDITION HOME --%>
		<c:when test="${mode == 'MODE_HOME'}">
			<%-- JUMBORTON DIV --%>
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to Homepage</h1>
				</div>
			</div>
		</c:when>

		<%-- CONDITION ALL PRODUCTS --%>
		<c:when test="${mode == 'MODE_PRODUCTS'}">
			<%-- TABLE DIV --%>
			<div class="container text-center" id="productsDiv">
				<h2 class="ctext">Provided Products</h2>
				<hr>
				<div class="table-responsive">
					<table class="table table-hover text-left">
						<thead>
							<tr class="gtext">
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
								<th>Location</th>
								<th>Date Posted</th>
								<th>Availability</th>
								<th>Done</th>
								<th>E</th>
								<th>D</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="product" items="${products}">
								<tr class="ltext">
									<td>${product.id}</td>
									<td>${product.name}</td>
									<td>${product.description}</td>
									<td>${product.location}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${product.date_posted}" /></td>
									<td>${product.availability}</td>
									<td>${product.done}</td>
									<td><a href="updateproduct?id=${product.id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deleteproduct?id=${product.id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		<%-- CONDITION POST or UPDATE --%>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<%-- FORM DIV --%>
			<div class="container text-center">
				<h2 class="fhdtext">Post Your Product NOW</h2>
				<hr>
				<form class="form-horizontal" method="POST" action="saveproduct">
					<input type="hidden" name="id" value="${product.id}" />
					<div class="form-group">
						<label class="control-label col-md-3 fl1text">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${product.name}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl2text">Description</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="description"
								value="${product.description}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl3text">Location</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="location"
								value="${product.location}" />
						</div>
					</div>
					<hr>
					<div class="form-group">
						<label class="control-label col-md-3 fl4text">Available</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="availability"
								value="true" />
							<div class="col-sm-1 rd1">Yes</div>
							<input type="radio" class="col-sm-1" name="availability"
								value="false" />
							<div class="col-sm-1 rd2">No</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl5text">Finished</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="done" value="true" />
							<div class="col-sm-1 rd3">Yes</div>
							<input type="radio" class="col-sm-1" name="done"
								value="false" />
							<div class="col-sm-1 rd4">No</div>
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-lg btn-primary"
							value="Post Now" />
					</div>
				</form>
			</div>
			
		</c:when>

	</c:choose>
	



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>
