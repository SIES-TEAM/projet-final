<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Persons</title>
	</head>

	<body>
		<h1>Persons :</h1>
		<h2>Add a user :</h2>
		<form action="/user/addUser">
			<input type="text" name="name" placeholder="name" />
			<input type="text" name="surname" placeholder="surname" />
			<select name="role">
            				<option value="USER">USER</option>
            				<option value="ADMIN">ADMIN</option>
            </select>
			<input type="submit" value="Add" />
		</form> 
		<!-- Formulaire en JSP -->
		
		<%-- <form:form method="POST" action="addPerson"
        modelAttribute="user">
        <form:label path="name">Nom</form:label>
        <form:input path="name" />
     
        <form:label path="surname">Pr�nom</form:label>
        <form:input path="surname" />
     
        <input type="submit" value="Submit" />
        </form:form> --%>
		<h1>Persons in database :</h1>
		<ul>
			 <c:forEach items="${persons}" var="user">
			 	<li>${user.name}&nbsp;${user.surname}&nbsp;<a href="/user/deletePerson?id=${user.id}">Delete</a>
			 		<a href="/user/updatePerson?id=${user.id }">Update</a>
			 	</li>
			 </c:forEach>
		</ul>
	</body>
</html>