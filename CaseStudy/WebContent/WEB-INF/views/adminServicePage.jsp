<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row">
		<div class="container col-sm-8 col-sm-offset-2 text-center"
			style="margin-top: 50px">
			<h2 class="text-center text-primary">
			<i class="fas fa-users-cog color-primary" aria-hidden="true"></i> Admin Service Page</h2>
			<p> You have successfully logged on as Admin</p>

			<form action="/CaseStudy/userList">
				<button type="submit" class="btn-lg btn-primary" style="margin-top: 20px" >Users</button>
			</form>
			<form action="/CaseStudy/adminScholarshipList" method="POST">
				<button type="submit" class="btn-lg btn-primary" style="margin-top: 20px">Scholarships</button>
			</form>

		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
