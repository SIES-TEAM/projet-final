
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<title> Rerservation d'une salles</title>
	</head>
<body>
             <div class="site-wrapper">
            <div class="site-wrapper-inner">
             <div class="cover-container">
             <jsp:include page="includes/header.jsp"></jsp:include>
		<h1>Réserver une salle</h1>
	 <form class="form-inline" action="/classroom/add">
		<input type="text" name="name" placeholder="Nom de la salles"/>
		<input type="text" name="capacity" placeholder="Capacite"/>
		<input type="submit" value="Ajouter" />
		
	</form>
	</div>
	</div>
	</div>
</body>

	
</html>