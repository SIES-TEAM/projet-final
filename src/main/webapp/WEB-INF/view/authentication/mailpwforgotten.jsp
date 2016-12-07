<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--commentaire --%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Saisir Votre Mail pour récupérer votre mot de passe</title>
</head>

<body>
	<form class="form-inline" action="/sendMP" >
		<input type="text"  name="email" placeholder="Entrer votre email">
		<input type="submit" value="Renvoyer">
	</form>
</body>
</html>