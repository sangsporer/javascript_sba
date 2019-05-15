<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container bg-light">
		<div class="row">

			<div class="container col-sm-10 col-sm-offset-1"
				style="margin-top: 50px">
				<h2 class="text-center text-primary"><i class="fas fa-users"></i>  User List</h2>
				<form action="/CaseStudy/newUser">
					<button type="submit" class="btn-primary btn-lg" style="margin: 25px">Add
						New User</button>
				</form>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Password</th>
							<th>Role</th>
							<th>Edit</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userList}" var="user">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
								<td>${user.email}</td>
								<td>${user.password}</td>
								<td>${user.role}</td>
								<td><a
									href="${pageContext.request.contextPath }/editUser/${user.id}"
									class="btn btn-warning">Edit</a></td>
								<td><a
									href="${pageContext.request.contextPath }/deleteUser/${user.id}"
									class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


<%@ include file="common/footer.jspf"%>
