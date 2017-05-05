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
	
	$("#addBtn").click(function() {
		event.preventDefault();
		//$("#addUser").hide();
		var userId = $("#addId").val();
//		var title = $("#title").val();
//		var publisher = $("#publisher").val();
//		var author1 = $("#author1").val();
//		var author2 = $("#author2").val();
		var user = {
			"userId" : userId
//			"userNa" : title,
//			"publisher": {"name" : publisher},
//			"authors" : [
//				{ "name" : author1 },
//				{ "name" : author2 }
//			]
		};
		$.ajax({
			url : 'rest/sample/user',
			type : 'post',
		//	dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(user),
			success : function(result, status, xhr) {
				alert("user added");
				//$("#addResult").show();
			}
		}).error(ajaxError);
//		.done(function(data){
//			alert("got response ajax res")
//			$("#addResult").show();
	});
	
});
function ajaxError(jqXHR, textstatus, errorThrown) {

	alert("errorThrown: " + errorThrown + " textstatus: " + textstatus
			+ " jqXHR: " + jqXHR)
}
