<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container col-sm-4 col-sm-offset-4" style="margin-top: 50px">
	<h2 class="text-center text-primary">
		<i class="fa fa-user color-primary" aria-hidden="true"></i> New User
	</h2>
	<form:form action="/CaseStudy/addUser" method="POST" modelAttribute="user">

		<label for="name">Name</label><br>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i
					class="fa fa-user color-primary"></i></span>
			</div>
			<form:input type="text" class="form-control" placeholder="Enter full name"
				path="name"/>
		</div>
		<label for="email">Email</label><br>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i
					class="fa fa-envelope color-primary"></i></span>
			</div>
			<form:input type="email" path="email" class="form-control" placeholder="email" />
		</div>


		<label for="password">Password</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i
					class="fa fa-key color-primary"></i></span>
			</div>
			<form:input type="password" class="form-control" id="password"
				placeholder="Enter password" path="password"/>
		</div>

		<label for="confirm">Confirm Password</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i
					class="fa fa-key color-primary"></i></span>
			</div>
			<form:input type="password" class="form-control" id="confirmPassword"
				placeholder="Confirm password" path="confirmPassword"/>
		</div>

		<label for="type">Role</label>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i
					class="fa fa-user-circle color-primary"></i></span>
			</div>
			<form:select path="role" class="form-control" id="role">
				<c:forEach var="role" items="${roles}">
					<form:option value="${role}">${role.description}</form:option>
				</c:forEach>
			</form:select>
		</div>
		
		
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>
