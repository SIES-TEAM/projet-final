<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create account </title>

	 <!-- Bootstrap core CSS -->
     <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

     <!-- Custom styles for this template -->
     <link href="/resources/css/signin.css" rel="stylesheet">
     
  </head>

  <body>
    <div class="container" action="/users/addUser">
          <form class="form-signin">
            <h2 class="form-signin-heading">Create account user</h2>
            <label for="inputLastname" class="sr-only">Nom</label>
            <input type="text" id="inputEmail" class="form-control" placeholder="Nom" required autofocus>
            <label for="inputFirstname" class="sr-only">Prénom</label>
            <input type="text" id="inputPassword" class="form-control" placeholder="Prénom" required>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
            <label for="inputEmail" class="sr-only">Confirmation</label>
            <input type="password" id="inputEmail" class="form-control" placeholder="Confirmation password" required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Role" required>

            <!-- <div class="checkbox">
              <label>
                <input type="checkbox" value="remember-me"> Remember me
              </label>
            </div> -->
            <button class="btn btn-lg btn-success btn-block" type="submit">Create account</button>
          </form>

        </div> <!-- /container -->
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
