<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title> Add a room</title>
	</head>
	<body>
		<div class="site-wrapper">
			<div class="site-wrapper-inner">
				<div class="cover-container">
					<h1>Ajouter une salle</h1>
					<form class="form-inline" action="/classroom/add">
					<input type="text" name="name" placeholder="Nom de la salle"/>
					<input type="text" name="capacity" placeholder="Capacité"/>
					<input type="submit" value="Ajouter" />
				</form>
				</div>
				<div style="margin: 30px">
					<a href="/classroom" class="btn btn-primary" role="button">Gestion des salles</a>
				</div>
			</div>
		</div>
	</body>

	
</html>