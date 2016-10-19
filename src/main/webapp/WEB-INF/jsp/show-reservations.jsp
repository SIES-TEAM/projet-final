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
    </head>
    <body>
    	<div class="container">
    	<div class="jumbotron">
    	<h2>Réservations </h2>
    	
    	</div>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>Identifiant</th>
		      <th>Date de création </th>
		      <th>Date début</th>
		      <th>Date fin</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${reservations }" var="reservation"> 
		    <tr>
		      <td>${reservation.userId }</td>
		      <th>${reservation.creationDate }</th>
		      <th>${reservation.dateBegin }</th>
		      <th>${reservation.dateEnd }</th>
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