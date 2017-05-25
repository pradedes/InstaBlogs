$(document).ready(function() {
	$("#centerDiv1").hide();
	$("#centerDiv3").hide();
	var title;
	var body;
	$.ajax({
		url : 'rest/blog',
		type : 'get',
		dataType : 'json',
		contentType: "application/json; charset=utf-8",
		success : function(data) {
			
			var countries = data;
			var cList = $('ul.mylist')
			$.each(countries, function(i) {
			    var li = $('<li/>')
			        .appendTo(cList);
			    $('<br/>')
			    .appendTo(li);
			    $('<br/>')
			    .appendTo(div);
			    
			 var div=   $("<div/>") 
			    	.addClass('w3-card-4')
			    	.click(function(e){
		    		$("#centerDiv").hide(),
		    		$("#centerDiv3").show(),
		    	
		    		$("#title3").text(data[i].blogTitle )
		    		$("#body3").text(data[i].blogBody)
		    	})
			    	.appendTo(li);
			    	
		
			    
			    var a = $('<h3>')
			        .text( data[i].blogTitle )
			        .appendTo(div);
			    
			   
			    
			    var line = $('<br/>')
			    .appendTo(div);
		
		    var a1 = $('<a/>')
		       
		        .text( data[i].blogBody)
		        .appendTo(div);
			    
			});
			
		},
	});
	
	$("#createBlog").click(function(e) {
		$("#centerDiv").hide();
		$("#centerDiv1").show();
	});
	
	$("#submit").click(function() {
	
		var body = $("textarea#body").val();
		var title = $("#title").val();
		var hashTag = $("#hashTag").val();
		alert(body);
		alert(title);
		var blog = {
			"blogTitle" : "vidya",
			"blogBody" : "syerioekht"
		};
		$.ajax({
			url : 'rest/blog',
			type : 'post',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			data : JSON.stringify(blog),
			success : function() {
				$("#centerDiv1").hide();
				alert("Blog added successfully")
			},
			
		});
	});
	
	
	$("#findBtn").click(function() {
		$("#findForm").hide();
		var isbn = $("#isbnFind").val();
		
		$.ajax({
			url : 'rest/library/book/'+isbn,
			type : 'get',
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				$("#findResult").show();
			},
		});
	});
	
});
	





