<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Winner List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="jumbotron text-center bg-white" style="margin-bottom: 0">
		<img class="img-responsive"
			src="<%=request.getContextPath()%>/images/MEF-Logo.png">
		<h1></h1>
		<h1 class="display-4 font-weight-bolder">Scholarship Tracker</h1>
	</div>

	<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
		<a class="navbar-brand" href="#">Menu</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#">Donor</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Trustee</a></li>

				<li class="nav-item"><a class="nav-link"
					href="/CaseStudy/adminLogin.jsp">Admin</a></li>

				<li class="nav-item"><a class="nav-link" href="#">New</a></li>
			</ul>
		</div>
	</nav>

	<div class="container bg-light">
		<div class="row">

			<div class="container col-sm-8 col-sm-offset-2" style="margin-top: 50px">
				<h2 class="text-center text-primary">MEF Scholarship Winners</h2>
				<form action="/CaseStudy/newWinner" method="get">
					<button type="submit" class="btn-info" style="margin: 25px">Add
						New Winner</button>
				</form>
				<table class="table table-hover text-white bg-success">
					<thead>
						<tr>
							<th>ID</th>
							<th>Scholarship</th>
							<th>Name</th>
							<th>School</th>
							<th>Year</th>
							
							<th>Edit</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${winnerList}" var="winner">
							<tr>
								<td>${winner.id}</td>
								<td>${scholarship.name}</td>
								<td>${winner.name}</td>
								<td>${winner.school}</td>
								<td>${winner.year}</td>
								
								<td><a href="${pageContext.request.contextPath }/editWinner/${winner.id}" class="btn btn-warning">Edit</a></td>
								<td><a href="${pageContext.request.contextPath }/deleteWinner/${winner.id}" class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
