<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>update reservation</title>
	</head>

	<body>
		<h1></h1>
		<h2>Modifier une réservation :</h2>
		<form action="/resrvations/updateForm">
			<input></input>
			<input type="hidden" name="id" value="${person.id }"/>
			<input type="text" name="name" placeholder="name" value="${person.name }" />
			<input type="text" name="surname" placeholder="surname" value="${person.surname }"/>
			<input type="submit" value="Add" />
		</form> 
	</body>
</html>