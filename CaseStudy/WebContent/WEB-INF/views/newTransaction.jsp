<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container col-sm-4 col-sm-offset-4"
		style="margin-top: 50px">
		<h2 class="text-center text-primary">New Transaction</h2>
		<form:form action="addTransaction" method="POST"
			modelAttribute="transaction">

				
			
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


<%@ include file="common/footer.jspf"%>
