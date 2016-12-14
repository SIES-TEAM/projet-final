<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%--&lt;%&ndash;<!DOCTYPE html>&ndash;%&gt;--%>
<%--&lt;%&ndash;<html lang="en">&ndash;%&gt;--%>
  <%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<title>header</title>--%>

	<%--<!-- Bootstrap core CSS -->--%>
    <%--<link href="../webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template -->--%>
   <%--<link href="<c:url value="../resources/css/home.css" />" rel="stylesheet">--%>

  <%--</head>--%>

  <div class="masthead clearfix">
      <div class="inner">
          <h3 class="masthead-brand">LOGO HERE</h3>
          <nav>
              <ul class="nav masthead-nav">
                  <li class="active"><a href="/">Home</a></li>
                  <security:authorize access="hasAuthority('ADMIN')">
                      <li>
                          <div class="dropdown">
                              <button class="btn  btn-lg dropdown-toggle" type="button" data-toggle="dropdown">Gestion
                                  <span class="caret"></span></button>
                              <ul class="dropdown-menu">
                                  <li><a href="/reservations">RESERVATIONS</a></li>
                                  <li><a href="/users">UTILISATEURS</a></li>
                              </ul>
                          </div>
                      </li>
                  </security:authorize>
                  <security:authorize access="isAuthenticated()">
                      <li><a href="/users/profil">
                          <security:authorize access="isAuthenticated()">
                              <security:authentication property="principal.username" />
                          </security:authorize>
                      </a></li>
                      <li><a href="/logout" class="btn btn-lg btn-danger">Logout</a></li>
                  </security:authorize>

                  <security:authorize access="!isAuthenticated()">
                      <li><a href="/users/form/adduser"   class="btn btn-lg btn-success">Sign up</a></li>
                      <li><a href="/login" class="btn btn-lg btn-info login">Login</a></li>
                  </security:authorize>

                  <li><span class="glyphicons glyphicons-user"></span></li>
              </ul>
          </nav>
      </div>
  </div>


  <%--<!-- Bootstrap core JavaScript--%>
    <%--================================================== -->--%>
    <%--<!-- Placed at the end of the document so the pages load faster -->--%>
    <%--<script src="../webjars/jquery/3.1.1/jquery.min.js"></script>--%>
    <%--<script src="../webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

<%--</html>--%>
