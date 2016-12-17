<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Ajouter un ordinateur</title>
	</head>

	<body>
		 <div class="site-wrapper">
            <div class="site-wrapper-inner">
             <div class="cover-container">
		<h1>Ajouter un ordinateur</h1>

			<h2>Choissir le model de l'ordinateur</h2>
			<form class="form-inline" action="/laptops/add">
				<input type="text" name="name" placeholder="Nom de l'ordinateur" />
				<input type="text" name="brand" placeholder="Marque de l'ordinateur" />
			
				<input type="submit" value="Ajouter" />
			</form>
		<br/>
		</div>
		</div>
		</div>
	</body>
</html>