<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/resources/img/favicon.ico" />" rel="icon">

    <title>Admin dashboard</title>

    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-3 col-md-2 sidebar">
                <ul class="nav nav-sidebar">
                    <li class="active"><a href="#">Overview <span class="sr-only">Réservations</span></a></li>
                    <li><a href="#">Historique</a></li>
                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href="">Ressorces</a></li>

                </ul>
                <ul class="nav nav-sidebar">
                    <li><a href=""></a></li>

                </ul>
            </div>
            <h1 class="page-header">Dashboard</h1>

            <ul class="nav nav-tabs">
                <li role="presentation" class="active"><a href="#">Réservations</a></li>
                <li role="presentation"><a href="#">Ressources</a></li>
                <li role="presentation"><a href="#">Utlisateurs</a></li>
                <li role="presentation"><a href="#">Messages</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
