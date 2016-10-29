<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> --%>
<html>
	<head>
		<title>Gestion des réservations</title>
	</head>

	<body>
		<jsp:include page="includes/header.jsp"></jsp:include>
		<h1>GESTION RESERVATIONS :</h1>
		<%-- <security:authorize access="isAuthenticated()"> --%>
			<h2>Ajouter une réservation</h2>
			<form class="form-inline" action="/reservations/add">
				<input type="text" name="userId" placeholder="userId" />
				<input type="date" name="creationDate" placeholder="Date de création" />
				<input type="date" name="dateBegin" placeholder="Date début" />
				<input type="date" name="dateEnd" placeholder="Date fin" />
				<input type="submit" value="Ajouter" />
			</form>
		<%-- </security:authorize>
		
		<security:authorize access="isAuthenticated()"> --%>
			<%-- <form class="form-inline" action="/logout" method="post">
				<input type="submit" value="Log out" />
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form> --%>
		<%-- </security:authorize> --%>
		<br/>
	</body>
</html>