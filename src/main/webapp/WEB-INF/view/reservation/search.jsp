<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation search criteria</title>
    <script
            src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <!--<link rel="stylesheet" href="/resources/demos/style.css"> -->
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <!-- Bootstrap core CSS -->
    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <!-- -->
    <script>
        $( function() {
            $( "#bookingDate" ).datepicker({ minDate: new Date(), maxDate: "+1M +10D" });
        } );
    </script>
</head>
<body>
<div class="container">
<div class="bootstrap-iso">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 col-sm-6 col-xs-12">
            <div class="alert alert-info">
                <h3>Cherchez les ressources en fonction de la date</h3>
            </div>
            <c:if test="${info != null} ">
                <div class="alert alert-danger">
                    <h4><span class="glyphicon glyphicon-exclamation-sign "> ${info}</span></h4>
                </div>
            </c:if>
            <form class="form-inline" method="get" action="/reservations/resources/search">
                <div class="form-group"> <!-- Date input -->
                    <label class="control-label" for="bookingDate">Date de réservation</label>
                    <input class="form-control" id="bookingDate" name="bookingDate" placeholder="DD/MM/YYYY" type="date"/>
                </div>
                <select class="carousel form-control" id="startTime" name="startTime">
                    <option>09:00</option>
                    <option>10:00</option>
                    <option>11:00</option>
                    <option>12:00</option>
                    <option>13:00</option>
                    <option>14:00</option>
                    <option>15:00</option>
                    <option>16:00</option>
                    <option>17:00</option>
                    <option>18:00</option>
                </select>
                <select class="carousel form-control" id="endTime" name="endTime">
                    <option>10:00</option>
                    <option>11:00</option>
                    <option>12:00</option>
                    <option>13:00</option>
                    <option>14:00</option>
                    <option>15:00</option>
                    <option>16:00</option>
                    <option>17:00</option>
                    <option>18:00</option>
                    <option>19:00</option>
                </select>
                <div class="form-group"> <!-- Submit button -->
                    <button class="btn btn-primary " name="submit" value="submit" type="submit">Rechercher</button>
                </div>
            </form>

        </div>
    </div>
</div>
</div>
</div>

<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
