<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container bg-light">
	<div class="row">

		<div class="container" style="margin-top: 50px">
			<h2 class="text-center text-primary">
				<i class="fas fa-university"></i> Scholarship List
			</h2>

			<table class="table table-hover">
				<thead>
					<tr>
						<td>ID</td>
						<td>Name</td>
						<td>Type</td>
						<td>Size</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${scholarshipList}" var="scholarship">
						<tr>
							<td><a
								href="${pageContext.request.contextPath }/scholarshipPage/${scholarship.id}"
								class="btn btn-sm btn-primary">${scholarship.id}</a></td>
							<td>${scholarship.name}</td>
							<td>${scholarship.type}</td>
							
							<td>
							<fmt:formatNumber maxFractionDigits = "0" value = "${scholarship.size}" type = "currency"/></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
