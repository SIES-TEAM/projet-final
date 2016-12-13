
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>


<html>
 <head>
		<title> Rerservation d'une salles</title>
	    <script type="text/javascript" src="/ressources/js/jquery-3.1.1.min.js"></script>
	    <script type="text/javascript" src="/ressources/js/moment.min.js"></script>
	    <script type="text/javascript" src="/ressources/js/bootstrap.min.js"></script> 
	    <script type="text/javascript" src="/ressources/js/bootstrap-datetimepicker.min.js"></script>
	    <script type="text/javascript" src="/ressources/js/bootstrap-datetimepicker.js"></script>
	   <link rel="stylesheet" href="/ressources/css/bootstrap.min.css" />
	   <link rel="stylesheet" href="/ressources/css/bootstrap-datetimepicker.min.css" />
	   <link rel="stylesheet" href="/ressources/font/font-awesome.min.css" />
	  <link rel="stylesheet" href="/ressources/css/booking.css" />
	 
	  
	</head>
	
   <body>
		<h1>reserver une salle</h1>
		
  <form method="get" action="/reservations/reserverroom">
	<p>Reservez</p>
		
	 Salles : 
		
	 <select name="roomid">
			<option value="-1">aucun</option>
			<c:forEach items="${classrooms}" var="classroom">
			   <option value="${classroom.id}">${classroom.name}</option>
		    </c:forEach>
	 </select> 
   <br>	
   Laptops : 
	 <select name="laptopid">
		<option value="-1">aucun</option>
			<c:forEach items="${laptops}" var="laptop">
			 <option value="${laptop.id}">${laptop.name}</option>
		    </c:forEach>
	 </select> 
   <br>	
Date de début: 
	 <div class="form-group"><div class="input-group date" id="book-start">
	<input type="datetime-local" name="datebegin" class="form-control" id="book-start-input"
		placeholder="Date de début" /> <span class="input-group-addon">
		<span class="glyphicon glyphicon-calendar">
		</span></span>
	</div></div>
	<Br>
 Dat fin:<div class="form-group"><div class="input-group date" id="book-end" >
			<input  size="10"
					type="datetime-local" name="dateend" class="form-control" id="book-end-input"
					placeholder="Date de fin"/> 
					<span class="input-group-addon"><span class="glyphicon glyphicon-calendar">
					</span></span></div></div>
					
					
				<script type="text/javascript">
                   $(function () {
                       $('#datetimepicker1').datetimepicker();
            });
        </script> 
	<Br>	
	Utilisateur : <select name="userid">
		      <option value=""></option>
			<c:forEach items="${users}" var="user">
			  <option value="${user.id}">${user.name}&nbsp;${user.surname}</option>
	        </c:forEach>
	   </select>
	<Br>
				 <input type="submit" value="Confirmer">
				
		<Br>
		
	</form>
	<c:if test="${erreur != null}">
	        <div style="color: red;"><c:out value="${erreur}"/></div>
	    </c:if>
	    
	    <h2>Listes des reservations des salles </h2>
	   
	    <hr>
	    <table class="table" >
		  <thead class="thead-inverse" >
		    <tr>
		    <th>id reservation</th>
		      <th>Nom de la salle</th>
		      <th>Nom de l'ordinateur</th>
		      <th>date de creation </th>
		      <th>date début</th>
		      <th>date fin </th>
		      <th>nom d'utilisateur</th>
		      <th>Action</th>
		    </tr></thead>
		  <tbody>
		   <c:forEach items="${reservations}" var="reservation"> 
		    <tr>
		      <th>${reservation.id }</th>
		       <th>${reservation.classroom.name }</th>
		      <th>${reservation.laptop.name }</th>
		       <th>${reservation.creationdateformatted}</th>
		        <th>${reservation.datebeginformatted}</th>
		        <th>${reservation.dateendformatted}</th>
		       <th>${reservation.user.name }</th>
		     
		     <th><a href="/reservations/delete?id=${reservation.id}">Supprimer</a></th>
		      <th><a href="/reservations/updateReservationRInput?id=${reservation.id}">Modifier</a></th>
		    </tr>
		    </c:forEach>
		   </tbody  >
        </table>
	    
	    

  
</body>

<script type="text/javascript" src="/ressources/js/reservation.js"></script>
	
</html>