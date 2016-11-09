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
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href=".css" rel="stylesheet">
  </head>

  <body>
    <form class="form-horizontal" action="/users/addUser">
    <fieldset>

    <!-- Form Name -->
    <legend>Créer un compte</legend>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="lastname">Prénom</label>
      <div class="col-md-6">
      <input id="lastname" name="surname" type="text" placeholder="Entrer votre prénom" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="name">Nom</label>
      <div class="col-md-6">
      <input id="name" name="name" type="text" placeholder="Entrer un nom" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="email">Email</label>
      <div class="col-md-6">
      <input id="email" name="email" type="text" placeholder="Entrer votre email" class="form-control input-md" required="">
      <span class="help-block">Format: exemple@exemple.com</span>
      </div>
    </div>

    <!-- Password input-->
    <div class="form-group">
      <label class="col-md-4 control-label" for="password">Mot de passe</label>
      <div class="col-md-6">
        <input id="password" name="password" type="password" placeholder="Entrer un mot de passe" class="form-control input-md" required="">

      </div>
    </div>

    <!-- Text input-->
        <div class="form-group">
          <label class="col-md-4 control-label" for="role">ROLE</label>
          <div class="col-md-6">
          <input id="role" name="role" type="text" placeholder="Entrer un role" class="form-control input-md" required="">

          </div>
        </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="submit"></label>
      <div class="col-md-4">
        <button id="submit" name="submit" class="btn btn-success">Ajouter</button>
      </div>
    </div>

    </fieldset>
    </form>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
