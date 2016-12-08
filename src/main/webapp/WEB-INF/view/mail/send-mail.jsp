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

    <title> Contacter nous</title>

     <!-- Bootstrap core CSS -->
     <link href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
     <!-- Custom styles for this template -->
    <link href="/resources/css/signin.css" rel="stylesheet">
    </head>
<body>
<div class="container">

    <form class="form-signin" action="/mail/sendAndSaveMail/">
    <h3>Nous contacter</h3>

       <br>
            <label class="col-md-4 control-label" for="subject">Sujet</label>
        <input id="subject" name="subject" placeholder="" class="form-control input-md" type="text">
        <br>
            <label class="col-md-4 control-label" for="msgBody">Message</label>
        <textarea class="form-control" id="msgBody" name="msgBody"></textarea>

    	<button class="btn btn-lg btn-success btn-block" type="submit" >Envoyer</button>


    </form>
    </div> <!-- /container -->
</body>
</html>