<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>Add a laptop </title>

		<!-- Bootstrap core CSS -->
		<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>

	<body>
		 <div class="container">

		     	<h1>Ajouter un ordinateur</h1>

				<h2>Choissir le model de l'ordinateur</h2>
					<form class="form-inline" action="/laptops/add">
						<input type="text" name="name" placeholder="Nom de l'ordinateur" />
						<input type="text" name="brand" placeholder="Marque de l'ordinateur" />

						<input type="submit" value="Ajouter" />
					</form>
		            <br/>
				 <div style="margin: 30px">
					 <a href="/laptops" class="btn btn-primary" role="button">Gesstion d'ordinateurs</a>
				 </div>
		</div>
		 <!-- Bootstrap core JavaScript
         ================================================== -->
		 <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
		 <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>