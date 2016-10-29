<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Persons</title>
	</head>

	<body>
		<h1>Persons :</h1>
		<h2>Add a person :</h2>
		<form action="/person/addPerson">
			<input type="text" name="name" placeholder="name" />
			<input type="text" name="surname" placeholder="surname" />
			<input type="submit" value="Add" />
		</form> 
		<!-- Formulaire en JSP -->
		
		<%-- <form:form method="POST" action="addPerson"
        modelAttribute="person">
        <form:label path="name">Nom</form:label>
        <form:input path="name" />
     
        <form:label path="surname">Prénom</form:label>
        <form:input path="surname" />
     
        <input type="submit" value="Submit" />
        </form:form> --%>
		<h1>Persons in database :</h1>
		<ul>
			 <c:forEach items="${persons}" var="person">
			 	<li>${person.name}&nbsp;${person.surname}&nbsp;<a href="/person/deletePerson?id=${person.id}">Delete</a></li>
			 </c:forEach>
		</ul>
	</body>
</html>