<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation modification form</title>
    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>

    <!-- Bootstrap core CSS -->
    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />
    <link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
<div class="container">
    <div class="bootstrap-iso">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8 col-sm-6 col-xs-12">
                    <div class="alert alert-info">
                        <p>Cherchez les ressources en fonction de la date</p>
                    </div>
                    <form class="form-inline" method="get" action="/reservations/resources/search">
                        <input type="hidden" name="id" value="${reservation.id }"/>
                        <div class="form-group"> <!-- Date input -->
                            <label class="control-label" for="bookingDate">Date de réservation</label>
                            <input class="form-control" id="bookingDate" name="bookingDate" placeholder="YYYY-MM-DD" 
                    			   pattern="[0-9]{4}-[0-1][0-9]-[0-3][0-9]" title="Entrez une date au format YYYY-MM-DD"
                    			   value="${reservation.bookingDate}"
                    			   type="date"/>
                        </div>
                        <select class="carousel form-control" id="startTime" name="startTime" >
                            <option ${start_time_preselected[0]}>09:00</option>
                            <option ${start_time_preselected[1]}>10:00</option>
                            <option ${start_time_preselected[2]}>11:00</option>
                            <option ${start_time_preselected[3]}>12:00</option>
                            <option ${start_time_preselected[4]}>13:00</option>
                            <option ${start_time_preselected[5]}>14:00</option>
                            <option ${start_time_preselected[6]}>15:00</option>
                            <option ${start_time_preselected[7]}>16:00</option>
                            <option ${start_time_preselected[8]}>17:00</option>
                            <option ${start_time_preselected[9]}>18:00</option>
                        </select>
                        <select class="carousel form-control" id="endTime" name="endTime">
                            <option ${end_time_preselected[0]}>10:00</option>
                            <option ${end_time_preselected[1]}>11:00</option>
                            <option ${end_time_preselected[2]}>12:00</option>
                            <option ${end_time_preselected[3]}>13:00</option>
                            <option ${end_time_preselected[4]}>14:00</option>
                            <option ${end_time_preselected[5]}>15:00</option>
                            <option ${end_time_preselected[6]}>16:00</option>
                            <option ${end_time_preselected[7]}>17:00</option>
                            <option ${end_time_preselected[8]}>18:00</option>
                            <option ${end_time_preselected[9]}>19:00</option>
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
<script>
//    $(document).ready(function(){
//        var date_input=$('input[name="bookingDate"]'); //our date input has the name "bookingDate"
//        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
//        var options={
//            format: 'dd/mm/yyyy',
//            startDate: "new Date()",
//            todayBtn: "linked",
//            daysOfWeekDisabled: "0,6",
//            container: container,
//            todayHighlight: true,
//            autoclose: true,
//        };
//        date_input.datepicker(options);
//    })
</script>
<script src="webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
