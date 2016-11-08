<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>update classrooms</title>
	</head>

	<body>
		<h1></h1>
		<h2>Modifier la salle :</h2>
		<form action="/classroom/update">
			<input type="hidden" name="id" value="${classroom.id }"/>
			<input type="text" name="name" placeholder="name" value="${classroom.name }" /></br></br>
			<input type="text" name="capacity" placeholder="capacity" value="${classroom.capacity }"/></br></br>
			<input type="submit" value="Modifier" />
		</form> 
	</body>
</html>