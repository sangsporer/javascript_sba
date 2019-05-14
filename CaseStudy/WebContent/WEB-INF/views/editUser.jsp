<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container col-sm-4 col-sm-offset-4" style="margin-top: 50px">
	<h2 class="text-center text-primary"><i class="fas fa-edit"></i> Edit User</h2>
	<form:form action="editUser" method="POST"
		modelAttribute="user">

		<div class="form-group">
			<form:hidden class="form-control" path="id" />
		</div>

		<div class="form-group">
			<label for="name">Name</label>
			<form:input type="name" class="form-control" id="name"
				placeholder="Enter full name" path="name" />
		</div>

		<div class="form-group">
			<label for="email">Email</label>
			<form:input type="email" class="form-control" id="email"
				placeholder="Enter email" path="email" />
		</div>

		<div class="form-group">
			<label for="password">Password</label>
			<form:input type="password" class="form-control" id="password"
				placeholder="Enter password" path="password" />
		</div>

		<div class="form-group">
			<label for="confirm">Confirm Password</label>
			<form:input type="password" class="form-control" id="confirmPassword"
				placeholder="Confirm password" path="confirmPassword" />
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

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

</body>
</html>
