<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head>
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
		<title>Modification des reservation </title>

		 <!-- Bootstrap core CSS -->
         <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	</head>
   <body>
		
 <h3>Modifier reservation:</h3>
	<form action="/reservation/updateReservationRInput">
			 
		Salles : <select name="roomid">
			<option value=""></option>
			  <c:forEach items="${classrooms}" var="classroom">
				 <c:if test="${reservation.classroom.id==classroom.id}">
				 <option value="${classroom.id}" selected="selected">${classroom.name}</option></c:if>
			<c:if test="${reservation.classroom.id!=rclassroom.id}">
					<option value="${classroom.id}">${classroom.name}</option></c:if></c:forEach>
		</select> 
		
	   Ordinateur : <select name="laptopid">
			<option value=""></option>
			<c:forEach items="${laptops}" var="laptop">
				<c:if test="${reservation.laptop.id==laptop.id}">
					<option value="${laptop.id}" selected="selected">${laptop.id}&nbsp;${laptop.name}</option>
				</c:if>
				<c:if test="${reservation.laptop.id!=laptop.id}">
					<option value="${laptop.id}">${laptop.id}&nbsp;${laptop.name}</option></c:if></c:forEach>
		     </select>
		     
		  date debut : <input type="datetime-local" name="datebegin"
			value=<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value="${reservation.starts}"/>> 
		  date Fin : <input type="datetime-local" name="dateend"
		   value=<fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm" value="${booking.ends}"/>>
		   
		    <input name="id" value="${reservation.id}" type="hidden" /> 
		
		userid   <select name="userid">
		  <option value=""></option>
			 <c:forEach items="${users}" var="user">
				<c:if test="${reservation.user.id==user.id}">
					<option value="${user.id}" selected="selected">${user.name}&nbsp;${user.surname}</option></c:if>
				<c:if test="${reservation.user.id!=user.id}">
					<option value="${user.id}">${user.name}&nbsp;${user.surname}</option></c:if>
			    </c:forEach>
		</select> <input type="submit" value="Modifier" /> 
			 
	</form> 
</body>
</html>