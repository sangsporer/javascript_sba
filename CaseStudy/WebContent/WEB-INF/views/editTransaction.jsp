<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Edit Transaction</title>
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
				<li class="nav-item"><a class="nav-link" href="/CaseStudy">Home</a></li>
			</ul>
		</div>
	</nav>

	<div class="container col-sm-4 col-sm-offset-4"
		style="margin-top: 50px">
		<h2 class="text-center text-primary">Edit Transaction</h2>
		<form:form action="editTransaction" method="POST"
			modelAttribute="transaction">
			
			<div class="form-group">
				<form:hidden
					class="form-control" 
					path="id"/>
			</div>

			<div class="form-group">
				<label for="scholarship">Scholarship</label>
				<form:input type="text" class="form-control" id="scholarship"
					placeholder="Enter Scholarship name" path="scholarship" />
			</div>
			
			<div class="form-group">
				<label for="date">Date</label>
				<form:input type="date" class="form-control" id="date"
					placeholder="Enter date" path="date" />
			</div>

			<div class="form-group">
				<label for="type">Type</label>
				<form:select path="type" class="form-control" id="type">
					<c:forEach var="type" items="${types}">
						<form:option value="${type}">${type.description}</form:option>
					</c:forEach>
				</form:select>
			</div>
			
				<div class="form-group">
				<label for="toOrFrom">To/From</label>
				<form:input type="text" class="form-control" id="toOrFrom"
					placeholder="Enter To/From Name" path="toOrFrom" />
			</div>
			

			<div class="form-group">
				<label for="amount">Amount</label>
				<form:input type="number" class="form-control" id="amount"
					placeholder="Enter amount" path="amount" />
			</div>
			
			<div class="form-group">
				<label for="balance">Balance</label>
				<form:input type="number" class="form-control" id="balance"
					placeholder="Enter Balance" path="balance" />
			</div>
			
			<div class="form-group">
				<label for="description">Description</label>
				<form:input type="text" class="form-control" id="description"
					placeholder="Enter Description" path="description" />
			</div>

			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>

</body>
</html>
