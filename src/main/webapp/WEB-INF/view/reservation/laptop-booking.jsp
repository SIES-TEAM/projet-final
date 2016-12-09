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

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!--<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet"> -->
</head>
<body>
    <div class="site-wrapper">
     <div class="site-wrapper-inner">
        <div class="cover-container">
            <!-- flash message -->
            <c:if test="${message != null}">
                <div class="alert alert-succes">${message }</div>
            </c:if>
            <form class="form-inline">
                <select class="form-group">
                    <label for="room">Salle</label>
                    <input type="select" class="form-control" id="" placeholder="">
                </select>
                <select class="form-group">
                    <label for="laptop">Ordinateur</label>
                    <input type="select" class="form-control" id="" placeholder="">
                </select>
                <button type="submit" class="btn btn-default">Réserver</button>
            </form>


            <%--<c:forEach items="${availableLaptops}" var="availableLaptop">--%>
                <%--<tr>--%>
                    <%--<td>${availableLaptop.name}</td>--%>
                    <%--<td>${availableLaptop.brand}</td>--%>
                    <%--<td></td>--%>
                    <%--<th><a href="/reservations/laptop/add?id=${availableLaptop.id}&bookingDate=${bookingDate}&startTime=${startTime}&endTime=${endTime}">RÉSERVER</a></th>--%>
                <%--</tr>--%>
           <%----%>
        </div>
     </div>
</div>
</body>
</html>
