<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container bg-light">
	<div class="row">

		<div class="container" style="margin-top: 50px">
			<h2 class="text-center text-primary">
				<i class="fas fa-university"></i> Scholarship List
			</h2>
			<form action="/CaseStudy/newScholarship" method="get">
				<button type="submit" class="btn-primary btn-lg"
					style="margin: 25px">Add New Scholarship</button>
			</form>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Type</th>
						<th>Size</th>
						<th>Edit</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${scholarshipList}" var="scholarship">
						<tr>
							<td><a
								href="${pageContext.request.contextPath }/adminScholarshipPage/${scholarship.id}"
								class="btn btn-sm btn-primary">${scholarship.id}</a></td>
							<td>${scholarship.name}</td>
							<td>${scholarship.type}</td>

							<td><fmt:formatNumber maxFractionDigits="0"
									value="${scholarship.size}" type="currency" /></td>
							<td><a
								href="${pageContext.request.contextPath }/editScholarship/${scholarship.id}"
								class="btn btn-warning">Edit</a></td>
							<td><a
								href="${pageContext.request.contextPath }/deleteScholarship/${scholarship.id}"
								class="btn btn-danger">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
