<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${users}" var="user"> 
		  	<tr>
			    <td>First name: ${user.firstName}</td>
			    <td>Last name: ${user.lastName}</td> 
			    <td>
			    	<c:choose>
				    	<c:when test = "${user.gender == 0}">
				    		Gender: Male
				    	</c:when>
				    	<c:when test = "${user.gender == 1}">
				    		Gender: Female
				    	</c:when>
				    	<c:otherwise>
				    		Gender: N/A
				    	</c:otherwise>
			    	</c:choose>
			    </td> 
			</tr>
		</c:forEach>
	</table>
</body>
</html>