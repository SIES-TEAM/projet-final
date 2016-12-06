<%--
  Created by IntelliJ IDEA.
  User: salah
  Date: 05/12/16
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
</div>

<table class="table">
    <thead class="thead-inverse">
    <tr>
        <th>ORDINATEUR</th>
        <th>MARQUE</th>
        <th>DATE</th>
        <th>ACTION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${availableLaptops}" var="availableLaptop">
        <tr>
            <td>${availableLaptop.name}</td>
            <td>${availableLaptop.brand}</td>
            <td></td>
            <th><a href="/reservations/laptop/add?id=${availableLaptop.id}&bookingDate=${bookingDate}&startTime=${startTime}&endTime=${endTime}">RÉSERVER</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
