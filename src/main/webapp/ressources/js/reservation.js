
$(document).ready(function() {
	  $('#book-start').datetimepicker({
		  format: "YYYY-MM-DD HH:mm"
	      //sideBySide: true,
	  });
	  $('#book-end').datetimepicker({
		  format: "YYYY-MM-DD HH:mm",
	      useCurrent: false //Important! See issue #1075
	  });
	  $("#book-start").on("dp.change", function (e) {
	      $('#book-end').data("DateTimePicker").minDate(e.date);
	  });
	  $("#book-end").on("dp.change", function (e) {
	      $('#book-start').data("DateTimePicker").maxDate(e.date);
	  });
	});

