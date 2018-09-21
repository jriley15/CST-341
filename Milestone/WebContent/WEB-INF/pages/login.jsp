
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>

	span {
	
		color: red;
	}
</style>

<body>
	<h2>Login</h2>
	<form:form method="POST" action="doLogin" modelAttribute="request">

		<form:errors path="*"/>
		<table>
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

	
		</table>
		<br>
		<input type="submit" value="Submit" />
	</form:form>

</body>
