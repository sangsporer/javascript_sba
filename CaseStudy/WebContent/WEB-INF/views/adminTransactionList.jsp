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


		<div class="container col-sm-8 col-sm-offset-2"
			style="margin-top: 50px">
			<h2 class="text-center text-primary">Transactions</h2>

			<div>
				<a
					href="${pageContext.request.contextPath }/scholarship/${scholarship.id}/newTransaction"
					class="btn btn-success" style="margin: 20px">New Transaction</a>
			</div>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Date</th>
						<th>Type</th>
						<th>To/From</th>
						<th>Amount</th>
						<th>Balance</th>

						<th>Edit</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${transactionList}" var="transaction">
						<tr>
							<td>${transaction.id}</td>
							<td>${transaction.date}</td>
							<td>${transaction.type}</td>
							<td>${transaction.toOrFrom}</td>
							<td><fmt:formatNumber value="${transaction.amount}"
									type="currency" /></td>

							<td><fmt:formatNumber value="${transaction.balance}"
									type="currency" /></td>

							<td><a
								href="${pageContext.request.contextPath }/editTransaction/${transaction.id}"
								class="btn btn-warning">Edit</a></td>
							<td><a
								href="${pageContext.request.contextPath }/deleteTransaction/${transaction.id}"
								class="btn btn-danger">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
</div>



<%@ include file="common/footer.jspf"%>
