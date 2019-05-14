<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

	<div class="container col-sm-4 col-sm-offset-4"
		style="margin-top: 50px">
		<h2 class="text-center text-primary">${scholarship.name} New Recipient</h2>
		<form:form action="newScholarshipWinner" method="POST"
			modelAttribute="winner">
			
			
			<div class="form-group">
				<form:hidden class="form-control" path="id" />
			</div>

			<div class="form-group">
				<label for="name">Name</label>
			
				<form:input type="text" class="form-control" id="name"
					placeholder="Enter name" path="name"></form:input>
				
			</div>

			<div class="form-group">
				<label for="school">School</label>
				
				<form:input type="text" class="form-control" id="school"
					placeholder="Enter school" path="school" ></form:input>
					
			</div>

			<div class="form-group">
				<label for="year">Year</label>
				
				<form:input type="date" class="form-control" id="year"
					placeholder="Enter year" path="year" ></form:input>
					
			</div>


			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>

<%@ include file="common/footer.jspf"%>
