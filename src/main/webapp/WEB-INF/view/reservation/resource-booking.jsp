<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>$Title$</title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
</head>
<body>
    <div class="site-wrapper">
     <div class="site-wrapper-inner">
        <div class="cover-container">
            <!-- flash message -->
            <c:if test="${message != null}">
                <div class="alert alert-succes">${message }</div>
            </c:if>
            <div class="inner cover">
            <h5> Il ya <span style="color: #018865;">${availableLaptops.size()}</span> ordinateur(s) disponible(s)
                pour le ${bookingDate} de ${startTime} à ${endTime}
            </h5>
           <form class="form-inline" method="get" action="/reservations/resource/add">
               <input type="hidden" name="bookingDate" value="${bookingDate}" />
               <input type="hidden" name="startTime" value="${startTime}" >
               <input type="hidden" name="endTime" value="${endTime}">
               <!-- Get a dropdown list of available laptops -->
               <div class="form-group">
                   <select class="carousel form-control" id="availableLaptop" name="laptopId" >
                       <c:forEach items="${availableLaptops}" var="laptop">
                           <option value="${laptop.id}" name="laptopId">${laptop.name} </option>
                       </c:forEach>
                   </select>
                   <select class="carousel form-control" id="availableRoom" name="roomId">
                       <c:forEach items="${availableRooms}" var="room">
                           <option value="${room.id}">${room.name} </option>
                       </c:forEach>
                   </select>
               </div>
               <div class="form-group">
                   <input  class="btn btn-primary " name="submit" value="Réserver" type="submit" />
               </div>

           </form>
            </div>

            <%--<c:forEach items="${availableLaptops}" var="availableLaptop">--%>
                <%--<tr>--%>
                    <%--<td>${availableLaptop.name}</td>--%>
                    <%--<td>${availableLaptop.brand}</td>--%>
                    <%--<td></td>--%>
                    <%--<th><a href="/reservations/laptop/add?id=${availableLaptop.id}&bookingDate=${bookingDate}&startTime=${startTime}&endTime=${endTime}">RÉSERVER</a></th>--%>
                <%--</tr>--%>
        </div>
     </div>
  </div>
</body>
</html>
