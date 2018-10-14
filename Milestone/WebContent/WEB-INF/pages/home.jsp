<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
	.carousel-size {
		margin-top: 10px;
		height: 500px;
	}
	
	#

</style>


<spring:url value="/resources/images/gcu.jpg" var="image1" />
<spring:url value="/resources/images/gcu1.jpg" var="image2" />
<spring:url value="/resources/images/gcu2.jpg" var="image3" />


<div class="container">

	<p class="text-center"><h2>Welcome to GCU Chat!</h2></h2></p>
	<p class="text-center">Register and Login to start chatting</p>

	<div>${model.message}</div>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class=".active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner carousel-size">
			<div class="carousel-item active">
				<img class="d-block w-100" src="${image1}" alt="First slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image2}" alt="Second slide">
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="${image3}" alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	
	

</div>


