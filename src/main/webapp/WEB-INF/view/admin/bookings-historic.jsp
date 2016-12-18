<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Historic of reservations</title>

    <!-- Bootstrap core CSS -->
    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="<c:url value="/resources/css/dashboard.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <%--<jsp:include page="../includes/header.jsp"></jsp:include>--%>

    <div class="alert-info">
        <h3>Historique des réservations</h3>
    </div>

    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>UTILISATEUR</th>
            <th>ORDINATEUR</th>
            <th>SALLE</th>
            <th>DATE DE CRÉATION </th>
            <th>DATE RÉSÉRVATION</th>
            <th>HEURE DÉBUT</th>
            <th>HEURE FIN</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${reservations }" var="reservation">
            <tr>
                <td>${reservation.user.surname}</td>
                <td>${reservation.laptop.name}</td>
                <td>${reservation.classroom.name}</td>
                <th>${reservation.creationDate }</th>
                <th>${reservation.bookingDate }</th>
                <th>${reservation.startTime }</th>
                <th>${reservation.endTime }</th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a href="/" class="btn btn-info" role="button">Accueil</a>
    </div>
</div>

<!-- Bootstrap core JavaScript -->
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>