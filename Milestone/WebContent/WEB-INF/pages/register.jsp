
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>

	span {
	
		color: red;
	}
</style>

<body>
	<h2>Registration</h2>
	<form:form method="POST" action="doRegister" modelAttribute="request">

		<!-- <form:errors path="*"/> -->

		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td>
					<form:input path="firstName"/>
					<br>
					<form:errors path="firstName"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td>
					<form:input path="lastName"/>
					<br>
					<form:errors path="lastName"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="email">Email Address</form:label></td>
				<td>
					<form:input path="email"/>
					<br>
					<form:errors path="email"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td>
					<form:password path="password"/>
					<br>
					<form:errors path="password"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="passwordConfirm">Confirm Password</form:label></td>
				<td>
					<form:password path="passwordConfirm"/>
					<br>
					<form:errors path="passwordConfirm"/>
				 </td>
			</tr>
	
		</table>
		<br>
		<input type="submit" value="Submit" />
	</form:form>

</body>
