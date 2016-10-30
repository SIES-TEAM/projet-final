<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    	<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
        <title>Listes de tous les salles</title>
        
        <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    	<div class="container">
    	<div class="jumbotron">
    	<h2>Classrooms </h2>
    	
    	</div>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>Nom de la salle</th>
		      <th>Capacité de la salle </th>
		      <th>Action</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${classrooms}" var="classroom"> 
		    <tr>
		      <td>${classroom.name }</td>
		      <th>${classroom.capacity }</th>
		      <th><a href="/classroom/delete?id=${classroom.id}">Supprimer</a></th>
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