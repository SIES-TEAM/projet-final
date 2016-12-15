<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/img/favicon.ico" />" rel="icon">

    <title>Mon profil</title>

  </head>

  <body>

    <div class="container">
      <h2>Mon profil</h2>
      <ul>
        <li>Nom: ${myInfos.name}</li>
        <li>Prénom: ${myInfos.surname}</li>
        <li>Email: ${myInfos.email}</li>
      </ul>
      <a href="/">
        <button class="btn btn-success" type="submit"> Retour a la page d'accueil </button>
      </a>

    </div> <!-- /container -->
  </body>
</html>
