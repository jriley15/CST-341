<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
span {
	color: red;
}

.form-group {
	text-align: left;
}




</style>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Sign In</h5>

					<form:form method="POST" action="doLogin" modelAttribute="request">
					
						<form:errors path="*" />
						
						<div class="form-group">
							<label for="email">Email</label>
							<form:input path="email" cssClass="form-control" placeholder="Email address" required="required" id="email" autofocus="autofocus" value="test@live.com" /> 
							<form:errors path="email" />
						</div>

						<div class="form-group">
						
							<label for="password">Password</label>
							<form:password path="password" cssClass="form-control" placeholder="Password" required="required" id="password" value="password" /> 
							
							<form:errors path="password" />
						</div>

						<button class="btn btn-dark btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>

						<hr class="my-4">

					</form:form>
				</div>

			</div>
		</div>
	</div>
</div>
