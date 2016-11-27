<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    	<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    
        <title>List of laptops </title>
        
        <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    	<div class="container">
    	<div class="jumbotron">
    	<h2> Ordinateurs </h2>
    	</div>
    	<table class="table">
		  <thead class="thead-inverse">
		    <tr>
		      <th>Identifiant</th>
		      <th>Nom de l'ordinateur</th>
		      <th>Marque de l'ordinateur</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${laptops }" var="laptop"> 
		    <tr>
		      <td>${laptop.id }</td>
		      <th>${laptop.name }</th>
		      <th>${laptop.brand }</th>
		      <th><a href="/laptops/delete?id=${laptop.id}">Supprimer</a></th>
		      <th><a href="/laptops/update?id=${laptop.id}">Modifier</a></th>
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