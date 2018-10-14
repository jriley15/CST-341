
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
						<h5 class="card-title text-center">Sign-up</h5>

						<form:form method="POST" action="doRegister"
							modelAttribute="request">
							<form:errors path="*" />
							<div class="form-group">
								<label for="firstName">First Name</label>
								<form:input path="firstName" id="firstName" cssClass="form-control" placeholder="First Name" required="required" autofocus="autofocus" />
								<form:errors path="firstName" />
							</div>

							<div class="form-group">
								<label for="lastName">Last Name</label>
								<form:input path="lastName" id="lastName" cssClass="form-control" placeholder="Last Name" required="required" />
								<form:errors path="lastName" />
							</div>
						
							<div class="form-group">
								<label for="email">Email</label>
								<form:input path="email" id="email" cssClass="form-control" placeholder="Email" required="required" />
								<form:errors path="email" />
							</div>

							<div class="form-group">
								<label for="password">Password</label>
								<form:password path="password" id="password" cssClass="form-control" placeholder="Password" required="required" /> 
										<form:errors path="password" />
							</div>

							<div class="form-group">
								<label for="passwordConfirm">Confirm Password</label>
								<form:password path="passwordConfirm" id="passwordConfirm" cssClass="form-control" placeholder="Confirm Password" required="required" /> 
								<form:errors path="passwordConfirm" />
							</div>

							<button
								class="btn btn-dark btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Sign-up</button>

							<hr class="my-4">

						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
