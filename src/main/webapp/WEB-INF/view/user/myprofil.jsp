<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>acces denied</title>

  </head>

  <body>

    <div class="container">
      <h2>Mon profil</h2>
      <ul>
        <li>Nom: ${myInfos.name}</li>
        <li>Prénom: ${myInfos.surname}</li>
        <li>Email: ${myInfos.email}</li>
      </ul>
      <p><a href="/"> Home</a> </p>
    </div> <!-- /container -->
  </body>
</html>
