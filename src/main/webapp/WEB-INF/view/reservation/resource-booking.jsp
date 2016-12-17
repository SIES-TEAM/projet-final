<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>$Title$</title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <%--<link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">--%>
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
</head>
<body>
    <div class="site-wrapper">
     <div class="site-wrapper-inner">
        <div class="cover-container">
            <div class="bootstrap-iso">
            <!-- flash message -->
            <c:if test="${message != null}">
                <div class="alert alert-succes">${message }</div>
            </c:if>
            <div class="inner cover ">
                <div class="alert-info ">
                    <h3> Il ya <span style="color: #018865;">${availableLaptops.size()}</span> ordinateur(s)
                        et <span style="color: #018865;">${availableRooms.size()}</span> disponible(s)
                        pour le ${bookingDate} de ${startTime} à ${endTime}
                    </h3>
                </div>

           <form class="form-inline" method="get" action="/reservations/resource/add">
               <input type="hidden" name="bookingDate" value="${bookingDate}" />
               <input type="hidden" name="startTime" value="${startTime}" >
               <input type="hidden" name="endTime" value="${endTime}">

               <div class="form-group">
                   <!-- Get a dropdown list of available laptops -->
                   <select class="carousel form-control" id="availableLaptop" name="laptopId" >
                       <c:forEach items="${availableLaptops}" var="laptop">
                           <option value="${laptop.id}" name="laptopId">${laptop.name} </option>
                       </c:forEach>
                   </select>
                   <!-- Get a dropdown list of available rooms -->
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

            </div>
        </div>
     </div>
  </div>
</body>
</html>
