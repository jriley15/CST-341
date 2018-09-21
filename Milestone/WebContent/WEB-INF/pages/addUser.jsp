
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<form:form method="POST" action="adduser" modelAttribute="user">

		<form:errors path="*"/>

		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td>
					<form:input path="firstName"/>
					<form:errors path="firstName"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td>
					<form:input path="lastName"/>
					<form:errors path="firstName"/>
				 </td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td>
					<form:radiobutton path="gender" value="0"/>Male 
					<form:radiobutton path="gender" value="1"/>Female 
					<form:errors path="gender"/>
				 </td>
			</tr>
			<tr>
			
				<td><input type="submit" value="Submit" /></td>
				
			</tr>
	
		</table>
		
	</form:form>

</body>
