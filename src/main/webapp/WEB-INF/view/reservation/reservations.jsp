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

        <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    </head>
    <body>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    	<div class="container">
    	<div class="jumbotron">
    	<h2>RÉSERVATIONS </h2>
    	
    	</div>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>UTILISATEUR</th>
			  <th>ORDINATEUR</th>
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
		      <td>${reservation.user.surname}</td>
			  <td>${reservation.laptop.name}</td>
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