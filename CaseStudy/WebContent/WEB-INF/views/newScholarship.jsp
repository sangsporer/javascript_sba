<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container col-sm-4 col-sm-offset-4" style="margin-top: 50px">
	<h2 class="text-center text-primary"> <i class="fas fa-university"></i> New Scholarship</h2>
	<form:form action="addScholarship" method="POST"
		modelAttribute="scholarship">

		<div class="form-group">
			<label for="name">Name</label>
			<form:input type="text" class="form-control" id="name"
				placeholder="Enter name" path="name" />
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
			<label for="size">Size</label>
			<form:input type="number" class="form-control" id="size"
				placeholder="Enter Size" path="size" />
		</div>


		<div class="form-group">
			<label for="detail">Detail</label>
			<form:textarea type="string" class="form-control" id="detail"
				placeholder="Enter detail" path="detail" />
		</div>

		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>
