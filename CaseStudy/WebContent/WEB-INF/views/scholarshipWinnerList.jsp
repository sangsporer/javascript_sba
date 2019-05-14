<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container bg-light">
	<div class="row">

		<div class="container col-sm-8 col-sm-offset-2"
			style="margin-top: 50px">
			<h2 class="text-center text-primary">${scholarship.name} Recipients</h2>
			<form
				action="${pageContext.request.contextPath }/newWinner"
				method="GET">
				<button type="submit" class="btn-primary btn-lg" style="margin: 25px">Add
					New Recipient</button>
			</form>
			<p>${name}</p>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>School</th>
						<th>Year</th>
						<th>Edit</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${scholarshipWinnerList}" var="winner">
						<tr>
							<td>${winner.id}</td>
							<td>${winner.name}</td>
							<td>${winner.school}</td>
							<td><fmt:formatDate value="${winner.year}" pattern="yyyy"/></td>

							<td><a
								href="${pageContext.request.contextPath }/editWinner/${winner.id}"
								class="btn btn-warning">Edit</a></td>
							<td><a
								href="${pageContext.request.contextPath }/deleteWinner/${winner.id}"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
