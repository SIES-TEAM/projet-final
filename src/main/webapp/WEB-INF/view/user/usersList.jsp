<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    	<!-- Bootstrap core CSS -->
   	    <link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   	    
        <title>Liste des personnes inscrites</title>
    </head>
    <body>
      <div class="container">
		  <div style="margin-bottom: 30px">
			  <h3>Gestions des utilisateurs</h3>
		  </div>
		  <c:if test="${message != null}">
			  <div class="alert alert-success">
				  <h5><span class="glyphicon glyphicon-check"></span>${message}</h5>
			  </div>
		  </c:if>

		  <h4 style="margin: 30px">Liste des personnes inscrites</h4>
		  <div style="margin: 30px">
			  <a href="/admin/user/form/add" class="btn btn-success" role="button">Ajouter un utilisateur</a>
		  </div>
        <table class="table table-striped">
		  <thead class="thead-default">
		    <tr>
		      <th>#</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Email</th>
		      <th>Role</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${users }" var="user">
				    <tr>
				      <td>${user.id }</td>
				      <th>${user.name }</th>
				      <th>${user.surname}</th>
				      <th>${user.email}</th>
				      <th>${user.role}</th>
				      <th><a href="/admin/user/delete?id=${user.id}" class="btn btn-danger" role="button">Supprimer</a>
				          <a href="/admin/user/updateform?id=${user.id}" class="btn btn-info" role="button">Modifier</a>
				      </th>
				    </tr>
		    </c:forEach>
		  </tbody>
       </table>
		  <div>
			  <a href="/" class="btn btn-primary" role="button">Accueil</a>
		  </div>
     </div>
     
     <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>