<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.chat-container {
	width: 500px;
	height: 300px;
	overflow-y: scroll;
	text-align: left;
	padding: 10px;
	margin-bottom: 10px;
	background-color: #f5f5f5;
	border-color: #f5f5f5;
}

.error {
	color: red;

}
.input-group {

	width: 500px;
}


</style>



<c:choose>
	<c:when test="${errors != null}">
		<ul>
			<c:forEach items="${errors}" var="error">
				<li>${error}</li>
			</c:forEach>
		</ul>
		
	</c:when>
	<c:otherwise>
	
		<h2>Edit Message</h2>
		
		<form:form method="POST" action="editMessage" modelAttribute="editMessageRequest">
			<table>
				<tr>
					<td>
						<div class="input-group mb-3">
						  <form:input path="message" cssClass="form-control msg-input" placeholder="Message" aria-label="Message" aria-describedby="button-addon2" required="required" value="${editMessageRequest.message}" />
						  	<form:hidden path="id" value="${editMessageRequest.id}" />
						  
						  <div class="input-group-append">
						    <button class="btn btn-outline-primary" type="submit" id="button-addon2">Save</button>
						  </div>
						</div>
						<form:errors path="message" class="error" />
						
					</td>
				</tr>
			</table>
			<br>
		</form:form>
		
				
		<a href="/Milestone/chat/">Back to chat</a>
		
	</c:otherwise>
</c:choose>

<script>

	window.onload = function () {
		var objDiv = document.getElementById("chat-container");
		objDiv.scrollTop = objDiv.scrollHeight;
	}

	
</script>


