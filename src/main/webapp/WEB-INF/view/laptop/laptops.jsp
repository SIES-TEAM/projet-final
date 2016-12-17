<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    	<div class="jumbotron" style="background-color: #333333">
    	<h2 style="color: #ffffff"> Gestion des ordinateurs </h2>
    	</div>
			<div style="margin: 30px">
				<a href="/laptops/formAdd" class="btn btn-success" role="button"><span class="glyphicon glyphicon-plus"></span>  Ajouter un ordinateur</a>
			</div>
			<!-- Table of laptops -->
			<table class="table">
			  <thead class="thead-inverse">
				<tr>
				  <th>Nom de l'ordinateur</th>
				  <th>Marque de l'ordinateur</th>
				</tr>
			  </thead>
			  <tbody>
			   <c:forEach items="${laptops }" var="laptop">
				<tr>
				  <th>${laptop.name }</th>
				  <th>${laptop.brand }</th>
				  <th><a href="/laptops/delete?id=${laptop.id}">Supprimer</a></th>
				  <th><a href="/laptops/updateform?id=${laptop.id}">Modifier</a></th>
				</tr>
				</c:forEach>
			   </tbody>
			</table>
			<div style="margin: 30px">
				<a href="/" class="btn btn-primary" role="button">Accueil</a>
			</div>
        </div>
        
        <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>