<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/img/favicon.ico" />" rel="icon">

    <title>Home Page</title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">

</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h2 class="masthead-brand"><a href="/" style="text-decoration:none">Simplon & Company</a></h2>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li class="active"><a href="/">Home</a></li>

                            <!--    <li class="active"><a href="/">Home</a></li>-->
                            <security:authorize access="hasAuthority('ADMIN')">
                                <li>
                                    <div class="dropdown">
                                        <button class="btn btn-lg btn-success gestion" type="button"
                                                data-toggle="dropdown">Administration
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li class="dropdown-header">Réservations</li>
                                            <li><a href="/admin/bookings/current" class="btn btn-lg ">En cours</a></li>
                                            <li><a href="/admin/bookings/historic" class="btn btn-lg ">Historique</a></li>
                                            <li class="dropdown-header">Ressources</li>
                                            <li><a href="/classroom" class="btn btn-lg ">Salles</a></li>
                                            <li><a href="/laptops" class="btn btn-lg ">Ordinateurs</a></li>
                                            <li role="separator" class="divider"></li>
                                            <li><a href="/admin/users" class="btn btn-lg ">Utilisateurs</a></li>
                                        </ul>
                                    </div>
                                </li>
                            </security:authorize>
                            <security:authorize access="isAuthenticated()">
                                <li>
                                    <div class="dropdown">
                                        <button class=" btn btn-lg btn-success monCompte" type="button"
                                                data-toggle="dropdown">Mon compte
                                            <span class="caret"></span></button>
                                        <ul class="dropdown-menu">
                                            <li><a href="/users/profil" class="btn btn-lg ">Mon profil</a></li>


                                            <li><a href="/mail/formSend" class="btn btn-lg "> Contact </a></li>
                                            <li><a href="/logout" class="btn btn-lg btn-danger"> Logout </a></li>
                                        </ul>
                                    </div>
                                </li>


                            </security:authorize>

                            <security:authorize access="!isAuthenticated()">
                                <li><a href="/users/form/add/account" class="btn btn-lg btn-success">Sign up</a></li>
                                <li><a href="/login" class="btn btn-lg btn-info login">Login</a></li>
                            </security:authorize>

                            <li><span class="glyphicons glyphicons-user"></span></li>
                        </ul>
                    </nav>
                </div>
            </div>

          <div class="inner cover">
            <h1 class="cover-heading"><c:out value="${message }"></c:out></h1>
            <p class="lead">Bienvenue dans l'outil de gestion des ressources de Simplon</p>
            <p class="lead">
            	<security:authorize access="isAuthenticated()">
	         		<a href="/reservations/resources/searchform" class="btn btn-lg btn-default">Réserver une ressource</a>
	         	</security:authorize>
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              
            </div>
          </div>
        </div>

      </div>

    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
