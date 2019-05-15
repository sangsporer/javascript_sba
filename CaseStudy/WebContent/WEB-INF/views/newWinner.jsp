<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


	<div class="container col-sm-4 col-sm-offset-4"
		style="margin-top: 50px">
		<h2 class="text-center text-primary">New Winner</h2>
		<form:form action="addWinner" method="POST"
			modelAttribute="winner">

			<div class="form-group">
				<label for="scholarship">Scholarship</label>
				<form:select path="scholarship" class="form-control" id="scholarship">
					<c:forEach var="scholarship" items="${scholarshipList}">
						<form:option value="${scholarship}">${scholarship.id}</form:option>
					</c:forEach>
				</form:select>
				<small> <form:errors path="scholarship" cssClass="errormsg" /></small>
			</div>	

			<div class="form-group">
				<label for="name">Name</label>
				<form:input type="text" class="form-control" id="name"
					placeholder="Enter name" path="name"></form:input>
					<small> <form:errors path="name" cssClass="errormsg" /></small>
				
			</div>

			<div class="form-group">
				<label for="school">School</label>
				
				<form:input type="text" class="form-control" id="school"
					placeholder="Enter school" path="school" />
					<small> <form:errors path="school" cssClass="errormsg" /></small>
					
			</div>

			<div class="form-group">
				<label for="year">Year</label>
				
				<form:input type="date" class="form-control" id="year"
					placeholder="Enter year" path="year" />
					<small> <form:errors path="year" cssClass="errormsg" /></small>
					
			</div>


			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>

<%@ include file="common/footer.jspf"%>