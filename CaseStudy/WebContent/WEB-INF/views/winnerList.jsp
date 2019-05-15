<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container bg-light">
		<div class="row">

			<div class="container col-sm-10 col-sm-offset-1" style="margin-top: 50px">
				<h2 class="text-center text-primary">MEF All Scholarship Recipients</h2>
				<form action="/CaseStudy/newWinner" method="get">
					<button type="submit" class="btn-info" style="margin: 25px">Add
						New Winner</button>
				</form>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>sID</th>
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
								<td>${winner.scholarship.id}</td>
								<td>${winner.name}</td>
								<td>${winner.school}</td>
								<td><fmt:formatDate value="${winner.year}" pattern="yyyy" /></td>
								
								<td><a href="${pageContext.request.contextPath }/editWinner/${winner.id}" class="btn btn-warning">Edit</a></td>
								<td><a href="${pageContext.request.contextPath }/deleteWinner/${winner.id}" class="btn btn-danger">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

<%@ include file="common/footer.jspf"%>
