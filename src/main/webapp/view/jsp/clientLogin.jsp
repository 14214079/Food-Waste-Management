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

<title>Food Waste Management | Client Home</title>

<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/client.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>

<body background="static/image/5611.jpg">
	<!-- NAVBAR DIV -->
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="clienthome" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="clientsignup">Sign up</a></li>
					<li><a href="allclients">Registered Clients</a></li>
					<li><a href="allproducts">Available Products</a></li>
				</ul>
			</div>
		</div>
	</div>


	<c:choose>
		<%-- CONDITION HOME --%>
		<c:when test="${mode == 'MODE_CLIENT_HOME'}">
			<%-- JUMBORTON DIV --%>
			<div class="container" id="homeClientDiv">
				<div class="jumbotron text-center">
					<h1>Welcome Client</h1>
				</div>
			</div>
		</c:when>

		<%-- CONDITION ALL PRODUCTS --%>
		<c:when test="${mode == 'MODE_CLIENTS'}">
			<%-- TABLE DIV --%>
			<div class="container text-center" id="clientsDiv">
				<h2 class="ctext">All Clients</h2>
				<hr>
				<div class="table-responsive">
					<table class="table table-hover text-left">
						<thead>
							<tr class="gtext">
								<th>Id</th>
								<th>Name</th>
								<th>Company</th>
								<th>Contact</th>
								<th>Email Address</th>
								<th>Password</th>
								<th>E</th>
								<th>D</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="client" items="${clients}">
								<tr class="ltext">
									<td>${client.client_id}</td>
									<td>${client.client_name}</td>
									<td>${client.client_company}</td>
									<td>${client.client_contact}</td>
									<td>${client.client_email}</td>
									<td>${client.client_password}</td>
									<td><a href="updateclient?id=${client.client_id}"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deleteclient?id=${client.client_id}"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		<%-- CONDITION POST or UPDATE --%>
		<c:when
			test="${mode == 'MODE_CLIENT_NEW' || mode == 'MODE_CLIENT_UPDATE'}">
			<%-- FORM DIV --%>
			<div class="container text-center">
				<h2 class="fhdtext">Sign up NOW</h2>
				<hr>
				<form class="form-horizontal" method="POST" action="saveclient">
					<input type="hidden" name="client_id" value="${client.client_id}" />
					<div class="form-group">
						<label class="control-label col-md-3 fl1text">Your
							Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="client_name"
								value="${client.client_name}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl2text">Your
							Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control"
								name="client_password" value="${client.client_password}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl3text">Your Company
							Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="client_company"
								value="${client.client_company}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl4text">Contact
							Number</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="client_contact"
								value="${client.client_contact}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3 fl5text">Email
							Address</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="client_email"
								value="${client.client_email}" />
						</div>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-lg btn-primary"
							value="Signup Now" />
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
