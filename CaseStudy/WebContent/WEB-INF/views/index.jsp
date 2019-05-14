<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>



<div class="container">
	<div class="row">
		<div class="container col-sm-8 col-sm-offset-2 text-center"
			style="margin-top: 50px">
			<h1 class="text-primary">
				<i class="fa fa-lock color-primary" aria-hidden="true"></i> Login
			</h1>
			<br>
			<div class="btn-group">
				<form action="/CaseStudy/donor" method="POST">
					<button type="submit" class="btn btn-lg btn-success"
						style="margin: 50px">Donor</button>
				</form>
				<form action="/CaseStudy/trustee" method="POST">
					<button type="submit" class="btn btn-lg btn-success"
						style="margin: 50px">Trustee</button>
				</form>
				<form action="/CaseStudy/admin" method="POST">
					<button type="submit" class="btn btn-lg btn-success"
						style="margin: 50px">Admin</button>
				</form>
				<form action="/CaseStudy/newUser" method="POST">
					<button type="submit" class="btn btn-lg btn-success"
						style="margin: 50px">New</button>
				</form>
			</div>
		</div>
	</div>
</div>


<%@ include file="common/footer.jspf"%>