<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
	<head>
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	
		<title>Gestion des réservations</title>

		 <!-- Bootstrap core CSS -->
         <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

         <!-- Custom styles for this template -->
         <link href="../resources/css/signin.css" rel="stylesheet">
	</head>

	<body>
		 <div class="site-wrapper">
            <div class="site-wrapper-inner">
             <div class="cover-container">

		        <!--  -->
		        <c:if test="${info != null}">
				<div class="alert alert-succes">${info }</div>
			    </c:if>
		<h1>RESERVATION :</h1>
		<%-- <security:authorize access="isAuthenticated()"> --%>
			
			<h2>RECHERCHER UN ORDINATEUR</h2>
                <form class="form-inline" action="/reservations/laptop/search">
                    <label>DATE RESERVATION</label>
                    <input type="date" name="bookingDate" placeholder="Date de reservation" />
					<label>HEURE DEBUT</label>
                    <input type="time" name="startTime" placeholder="Heure de début">
					<label>HEURE FIN</label>
                    <input type="time" name="endTime" placeholder="Heure de fin">
                    <input type="submit" value="RECHERCHER" />
                </form>
				 <c:if test="${bookedLaptopList.size()>0}" >

				 <h3>Ordinateurs disponibles</h3>

				 <form class="form-inline" action="/reservations/laptop/add">
					 <input type="hidden" name="bookingDate" value="${searchParams.get(bookingDate)}" />
					 <input type="hidden" name="startTime" value="" >
					 <input type="hidden" name="endTime" value="">
					 <!-- Get a dropdown list of available laptops -->
					 <div class="dropdown">
						 <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							 Dropdown
							 <span class="caret"></span>
						 </button>
						 <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							 <c:forEach items="${availableLaptops}" var="availableLaptop">
								 <li>${availableLaptop.name} ${availableLaptop.brand}</li>
							 </c:forEach>
						 </ul>
					 </div>
					 <input type="submit" value="RESERVER" />
				 </form>
				 </c:if>

		<%-- </security:authorize>
		
		<security:authorize access="isAuthenticated()"> --%>
			<%-- <form class="form-inline" action="/logout" method="post">
				<input type="submit" value="Log out" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form> --%>
		<%-- </security:authorize> --%>
		<br/>
		</div>
		</div>
		</div>
		
		<!-- Bootstrap core JavaScript
        ================================================== -->
    	<!-- Placed at the end of the document so the pages load faster -->
    	<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    	<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>
</html>