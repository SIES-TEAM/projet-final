<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    	<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
        <title>Gestion des salles</title>
        
        <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    	<div class="container">
    	<div class="jumbotron">
    	<h2>Gestion des salles </h2>
    	
    	</div>
			<div style="margin: 30px">
				<a href="/classroom/formAdd" class="btn btn-success" role="button"><span class="glyphicon glyphicon-plus"></span>  Ajouter une salle</a>
			</div>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>Nom de la salle</th>
		      <th>Capacit� de la salle </th>
		      <th>Action</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${classrooms}" var="classroom"> 
		    <tr>
		      <td>${classroom.name }</td>
		      <th>${classroom.capacity }</th>
		      <th><a href="/classroom/delete?id=${classroom.id}">Supprimer</a></th>
		      
		      <th><a href="/classroom/updateClassroom?id=${classroom.id}">Modifier</a></th>
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