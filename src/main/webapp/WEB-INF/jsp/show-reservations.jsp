<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>List of reservations</title>
    </head>
    <body>
        <c:forEach items="${reservations }" var="reservation">
        	<p>${reservation.id} ${reservation.creationDate }</p>   
        </c:forEach>
    </body>
</html>