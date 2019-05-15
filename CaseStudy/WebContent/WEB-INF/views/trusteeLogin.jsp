<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container col-sm-4 col-sm-offset-4" style="margin-top: 50px">
	<h2 class="text-center text-primary">
		<i class="fa fa-lock color-primary" aria-hidden="true"></i>
		Trustee Login
	</h2>
	<br>
	<form action="/CaseStudy/trusteeLogin" method="POST">
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i class="fa fa-envelope color-primary"></i></span>
			</div>
			<input type="email" name="email" class="form-control"
				placeholder="email" />
		</div>
		
		<br>
		<div class="input-group">
			<div class="input-group-prepend">
				<span class="input-group-text"><i class="fa fa-key icon"></i></span>
			</div>
			<input type="password" name="password" class="form-control"
				placeholder="password" />
		</div>
		<br>
		<div class="form-group form-check">
			<label class="form-check-label"> <input
				class="form-check-input" type="checkbox" name="remember">
				Remember me
			</label>
		</div>
		<button type="submit" class="btn btn-success">Submit</button>
		<br>
		<br>
		<div class="footer">
		<p>
			Don't have an Account! <a href="#">Sign Up Here</a>
		</p>
		<p>
			Forgot <a href="#">Password?</a>
		</p>
	</div>
	</form>
</div>


<%@ include file="common/footer.jspf"%>
