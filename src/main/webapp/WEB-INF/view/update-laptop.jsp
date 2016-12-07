<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> --%>
<html>
	<head>
		<title>Modifier un ordinateur</title>
	</head>

	<body>
		 <div class="site-wrapper">
            <div class="site-wrapper-inner">
             <div class="cover-container">
		        <jsp:include page="includes/header.jsp"></jsp:include>
		<h1>Modifier un ordinateur</h1>
		<%-- <security:authorize access="isAuthenticated()"> --%>
			<h2>Choissir le model de l'ordinateur</h2>
			<form class="form-inline" action="/laptops/update">
				<input type="hidden" name="id" value="${laptop.id }" placeholder="Identifiant de l'ordinateur"/>
				<input type="text" name="name" value="${laptop.name}" placeholder="Nom de l'ordinateur" />
				<input type="text" name="brand" value="${laptop.brand}" placeholder="Marque de l'ordinateur" />
			
				<input type="submit" value="Modifier" />
			</form>
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
	</body>
</html>