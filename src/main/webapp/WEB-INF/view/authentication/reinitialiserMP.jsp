<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="en">

	  <head>
			    <meta charset="utf-8">
			    <meta http-equiv="X-UA-Compatible" content="IE=edge">
			    <meta name="viewport" content="width=device-width, initial-scale=1">
			    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
			    <meta name="description" content="">
			    <meta name="author" content="">
			    <link rel="icon" href="../../favicon.ico">
			    <title> Réinitialiser Votre Mot de Passe </title>
			    <!-- Bootstrap core CSS -->
			    <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
			    <!-- Custom styles for this template -->
			    <link href="/resources/css/signin.css" rel="stylesheet">
	  </head>
<body>
		   <div class="container">
			<form class="form-signin" action="/sendNouveauMP">
			 <h3> Réinitialiser Votre mot de passe</h3>
			  <!--  label for="inputAncienmp" class="sr-only">ancienne Mot de Passe</label>
		        <input type="password" name="anemail" id="anemail" class="form-control" placeholder="password" required autofocus>
		          -->
		      <label for="inputNouvellemp" class="sr-only">Nouvelle mot de passe</label>
		        <input type="password" name="newPassword" id="newPassword" class="form-control" placeholder="new password" required autofocus>
		         <br>
		      <label for="inputValNouvellemp" class="sr-only">Valider nouvelle mot de passe</label>
		        <input type="password" name="newPasswordControl" id="newPasswordControl" class="form-control" placeholder="valider Nouvelle mot de passe" required autofocus>
		         <br>
		         <!--  input type="text"  name="email" placeholder="Entrer votre email"-->
		        <br>
				<button class="btn btn-lg btn-success btn-block" type="submit" >Validez</button>
		</form>
		
		</div> <!-- /container -->
</body>
</html>