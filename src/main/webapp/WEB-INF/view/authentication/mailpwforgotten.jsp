<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Saisir Votre Mail pour r�cup�rer votre mot de passe</title>

    <!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">

  </head>
<body>
   <div class="container">

	<form class="form-signin" action="/sendMP">
	<h3>Réinitialisez votre mot de passe </h3>
	  <label for="inputEmail" class="sr-only">Addresse email</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
         <!--  input type="text"  name="email" placeholder="Entrer votre email"-->
       <br>
		<button class="btn btn-lg btn-success btn-block" type="submit" >Valider</button>
		
	</form>
	</div> <!-- /container -->
</body>
</html>