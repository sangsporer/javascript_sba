<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container bg-light">
	<div class="row">


		<div class="container text-center" style="margin-top: 50px">
			<h1 class="text-center text-primary text-uppercase">${scholarship.name}</h1>
			> <br>
			<h3>
				<fmt:formatNumber maxFractionDigits="0" value="${scholarship.size}"
					type="currency" />
			</h3>
			<h3>${scholarship.detail}</h3>


		</div>
		
		<div>
			<a
				href="${pageContext.request.contextPath }/scholarship/${scholarship.id}/newWinner"
				class="btn btn-success" style="margin: 20px">New Recipient</a>
		</div>

		<div>
			<a
				href="${pageContext.request.contextPath }/adminTransactionList/${scholarship.id}"
				class="btn btn-success" style="margin: 20px">Transaction List</a>
		</div>

		<div class="container">
			<h2 class="text-primary">Recipients</h2>
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
							<td><fmt:formatDate value="${winner.year}" pattern="yyyy" /></td>
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