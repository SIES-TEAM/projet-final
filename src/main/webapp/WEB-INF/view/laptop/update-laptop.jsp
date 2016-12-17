<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
	<head>
		<title>Modifier un ordinateur</title>
	</head>

	<body>
		 <div class="site-wrapper">
            <div class="site-wrapper-inner">
             <div class="cover-container">
		<h1>Modifier un ordinateur</h1>
			<h2>Choissir le model de l'ordinateur</h2>
			<form class="form-inline" action="/laptops/update">
				<input type="hidden" name="id" value="${laptop.id}" />
				<input type="text" name="name" placeholder="Nom de l'ordinateur" value="${laptop.name}"/>
				<input type="text" name="brand" placeholder="Marque de l'ordinateur" value="${laptop.brand}"/>
			
				<input type="submit" value="Modifier" />
			</form>
		<br/>
		</div>
		</div>
		</div>
	</body>
</html>