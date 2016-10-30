<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    	<!-- Bootstrap core CSS -->
   	    <link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
   	    
        <title>Liste des personnes inscrites</title>
    </head>
    <body>
    	<h3>Listes des personnes inscrites</h3>
        <table class="table">
		  <thead class="thead-default">
		    <tr>
		      <th>#</th>
		      <th>First Name</th>
		      <th>Last Name</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${persons }" var="person"> 
				    <tr>
				      <td>${person.id }</td>
				      <th>${person.name }</th>
				      <th>${person.surname}</th>
				      <th><a href="/person/delete?id=${person.id}">Delete</a>
				          <a href="/person" class="btn btn-info" role="button">Update</a>
				      </th>
				    </tr>
		    </c:forEach>
		  </tbody>
     </table>
     
     <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>