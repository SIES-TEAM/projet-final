<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
    <head>
    	<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
        <title>List of reservations</title>
        
        <!-- Bootstrap core CSS -->
    	<link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <link href="<c:url value="/resources/css/booking.css" />" rel="stylesheet">
    </head>
    <body>
    	<div class="container">
        <div class="jumbotron">
			<h3>Réservations en cours</h3>
		</div>
			<c:if test="${message != null}" var="msg">
				<div class="alert alert-success">
					<h4><span class="glyphicon glyphicon-check "> ${message}</span></h4>
				</div>
			</c:if>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>UTILISATEUR</th>
			  <th>ORDINATEUR</th>
			  <th>SALLE</th>
		      <th>DATE DE CRÉATION </th>
		      <th>DATE RÉSÉRVATION</th>
		      <th>HEURE DÉBUT</th>
			  <th>HEURE FIN</th>
			<security:authorize access="hasAuthority('ADMIN')">
		      <th>ACTION</th>
			</security:authorize>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${reservations }" var="reservation"> 
		    <tr>
		      <td>${reservation.user.surname}</td>
			  <td>${reservation.laptop.name}</td>
			  <td>${reservation.classroom.name}</td>
		      <th>${reservation.creationDate }</th>
		      <th>${reservation.bookingDate }</th>
		      <th>${reservation.startTime }</th>
			  <th>${reservation.endTime }</th>
				<security:authorize access="hasAuthority('ADMIN')">
		      <th>
				  <a href="/reservations/delete?id=${reservation.id}" data-toggle="tooltip" data-placement="bottom" title="Supprimer">
					  <span aria-hidden="true" class="glyphicon glyphicon-trash supprimer"></span>
				  </a>
				  <a href="/reservations/updateForm?id=${reservation.id}" data-toggle="tooltip" data-placement="bottom" title="Modifier">
					  <span class="glyphicon glyphicon-edit modifier"></span>
				  </a>
			  </th>
				</security:authorize>
		    </tr>
		    </c:forEach>
		   </tbody>
        </table>
				<div>
					<a href="/" class="btn btn-info" role="button">Accueil</a>
				</div>
        </div>
		<script>
            $(document).ready(function(){
                $('[data-toggle="tooltip"]').tooltip();
            });
		</script>

	<!-- Bootstrap core JavaScript -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>