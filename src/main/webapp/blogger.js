$(document).ready(function() {
	$("#findBtn").click(function(e) {
		event.preventDefault();
		
		$("#findUser").hide();
		var userId = $("#userId").val();
		$.ajax({
			url : 'rest/sample/user/' + userId,
			type : 'get',
			dataType : 'json',
			contentType : "application/json; charset=utf-8",
			success : function(data) {
				$("#userName").text(data.userName);
				$("#userDetails").show();
			}
		}).error(ajaxError);
	});
});
function ajaxError(jqXHR, textstatus, errorThrown) {

	alert("errorThrown: " + errorThrown + " textstatus: " + textstatus
			+ " jqXHR: " + jqXHR)
}
