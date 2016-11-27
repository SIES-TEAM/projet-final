<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    	<!-- Bootstrap core CSS -->
   	    <link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   	    
        <title>Liste des personnes inscrites</title>
    </head>
    <body>
      <div class="container">
    	<h3>Listes des personnes inscrites</h3>
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
				      <th><a href="/user/delete?id=${user.id}" class="btn btn-danger" role="button">Delete</a>
				          <a href="/user/update?id=${user.id}" class="btn btn-info" role="button">Update</a>
				      </th>
				    </tr>
		    </c:forEach>
		  </tbody>
       </table>
     </div>
     
     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>