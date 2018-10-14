<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
ul {
	padding: 0;
}

ul li {
	list-style-type: none;
	display: inline;
}

.logo {

	padding-right: 5px;
	width: 35px;
	height: 35px;
}

.btn-outline-gcupurple {

	color: white;
    background-color: transparent;
    background-image: none;
    border-color: #522398;

}

.btn-outline-gcupurple:hover {


	color: white;
	background-color: #522398;

}


</style>

<spring:url value="/resources/images/logo.png" var="logo" />


<div align="center">



	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="#"><img src="${logo}" class="logo"/>GCU Chat</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="/Milestone/">Home <span class="sr-only">(current)</span></a>
				</li>
				
			  <c:if test="${sessionScope.user != null}">
			  <li class="nav-item">
		      	<a class="nav-link" href="/Milestone/chat/view">Chat</a> 
		      	</li>
		      </c:if>
		      </ul>
		
		
			<ul class="navbar-nav ml-auto">
			
				<c:choose>
				  <c:when test="${sessionScope.user != null}">
				  	<li class="nav-item">
				 		<a class="btn btn-outline-gcupurple" href="/Milestone/user/logout">Logout</a> 
				 	</li>
				  </c:when>

				  <c:otherwise>
				 	 <li class="nav-item">
						<a class="btn btn-outline-gcupurple mr-sm-2" href="/Milestone/user/login">Login</a> 
					
					</li>
					<li class="nav-item">
						<a class="btn btn-outline-gcupurple" href="/Milestone/user/register">Sign up</a>
					</li>
				  </c:otherwise>
				</c:choose>
				
			
				
			</ul>


		</div>
	</nav>


</div>