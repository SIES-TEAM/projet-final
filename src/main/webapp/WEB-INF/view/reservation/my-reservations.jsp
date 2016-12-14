<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">

	<title>List of reservations</title>

	<!-- Bootstrap core CSS -->
	<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

	<link href="<c:url value="/resources/css/booking.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
	<jsp:include page="../includes/header.jsp"></jsp:include>
	<div class="jumbotron">
		<h3>Historique </h3>
	</div>

	<c:if test="${message != null}" var="msg">
		<div class="alert alert-success">
			<h4><span class="glyphicon glyphicon-check">${msg}</span></h4>
		</div>
	</c:if>
	<table class="table">
		<thead class="thead-inverse">
		<tr>
			<th>ORDINATEUR</th>
			<th>SALLE</th>
			<th>DATE DE CRÉATION </th>
			<th>DATE RÉSÉRVATION</th>
			<th>DÉBUT</th>
			<th>FIN</th>
			<th>ACTION</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${reservations }" var="reservation">
			<tr>
				<td>${reservation.laptop.name}</td>
				<td>${reservation.classroom.name}</td>
				<th>${reservation.creationDate }</th>
				<th>${reservation.bookingDate }</th>
				<th>${reservation.startTime }</th>
				<th>${reservation.endTime }</th>
				<th><a href="/reservations/delete?id=${reservation.id}">Supprimer</a></th>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>