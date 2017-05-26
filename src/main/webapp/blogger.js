$(document).ready(function() {
	reload();
	
	
	
	function reload(){
		$.ajax({
		
		
		url : 'rest/blog',
		type : 'get',
		dataType : 'json',
		contentType: "application/json; charset=utf-8",
		statusCode: {
		      204:function() {}
		},
		success : function(data,jqXHR) {
			var clist = $('ul.mylist');
			$('ul.mylist').empty();
			if(jqXHR === "nocontent"){
				  var a = $('<h1>')
			        .text("No blogs found" )
			        .appendTo(clist);
			    
			   
				return;
			}
			//alert(data.status);
			
			//alert(blogs);
			

			var blogs = data;
			var cList = $('ul.mylist')
			$.each(blogs, function(i) {
			    var li = $('<li/>')
			        .appendTo(cList);
			    $('<br/>')
			    .appendTo(li);
			    $('<br/>')
			    .appendTo(div);
			    
			 var div=   $("<div/>") 
			    	.addClass('w3-card-4')
			    	.click(function(e){
		    		$("#listingCard").hide(),
		    		$("#viewCard").show(),
		    	
		    		$("#title3").text(data[i].blogTitle )
		    		$("#body3").text(data[i].blogBody)
		    	})
			    	.appendTo(li);
			    	
		
			    
			    var a = $('<h3>')
			        .text( data[i].blogTitle ).addClass("w3-container")
			        .appendTo(div);
			    
			   
			    
			    var line = $('<br/>')
			   
		
//			    var a1 = $('<label/>')
//			    .css({"white-space":"normal"},
//			    {"width": "12em"} ,
//			    {"height": "3em"} ,
//			    {"overflow": "hidden"},
//			    {"text-overflow":"ellipsis"})
//			    .text( data[i].blogBody).addClass("w3-container")
//			    .appendTo(div);
			    
			    var a1 = $('<h6/>')
		
		        .text( data[i].blogBody).addClass("w3-container ell")
		        .appendTo(div);
	    
		    //var blogsData=blog;
			    
			});
			
		},
	});
	
	}	

	$("#findUserButton").click(function(e) {
		event.preventDefault();
		//alert(xhr.getResponseHeader('Header'));
		//alert($window.sessionStorage.accessToken);
		//$("#findUser").hide();
		var userId = $("#findUserId").val();
		//alert("find " + userId);
		$.ajax({
			// url : 'rest/user/' + userId,
			url : 'rest/user/' + userId,
			type : 'get',

     		//Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI0MjM2LCJleHAiOjE0OTU1MjUxMzZ9.GJoS7h4pALs_XenfAU7_PKN1YwvYAdoUjlFgHJej67D2a0MnnXlX9F5b6DL_RIQv-VvmE63UZliDrxjsA5ZscA
			//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MDc0LCJleHAiOjE0OTU1Mjk5NzR9.knKbZ2IEoTFQc7Nkp9mbqS6vwSot2YOUSZPQzJsXhuIRdhihJ9MOvygw86845TEZhqAv7pvMPNgvH7E6YoXVIg
			//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MjQ5LCJleHAiOjE0OTU1MzAxNDl9.89Zrc7Gz6bBiAap8Pz_0Vq_p07bGYoPnqi0jwV4A1_n9Q2FMK6BeBxWWBBWhq4_8v0pvUuHWAatHlHxeVK_gsQ
			 dataType : 'json',
			 contentType : "application/json; charset=utf-8",
			 beforeSend: function(xhr) {
				 	//alert('setting beaer');
				    //alert(xhr.getRequestHeader('Authorization'));
				 	//alert(xhr.getResponseHeader('Authorization'));
				 	 if(window.sessionStorage) { 
		                    alert(sessionStorage.getItem("Authorization"));
		                }
				    //alert(request.getResponseHeader('Authorization'));
			        xhr.setRequestHeader('Authorization', sessionStorage.getItem("Authorization"));
				 	//xhr.setRequestHeader('Authorization', "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MDc0LCJleHAiOjE0OTU1Mjk5NzR9.knKbZ2IEoTFQc7Nkp9mbqS6vwSot2YOUSZPQzJsXhuIRdhihJ9MOvygw86845TEZhqAv7pvMPNgvH7E6YoXVIg");
		      },
			success : function(data) {
				$("#userId").text(data.userLoginId);
				$("#userName").text(data.userName);
				$("#userEmail").text(data.email);
				$("#userDetails").show();
				alert(userProfile.userLoginId);
			}
		}).error(ajaxError);
	});
	var userData;	
	$("#loginButton").click(function(e) {
		event.preventDefault();

		//$("#findUser").hide();
		//var loginId = $("#findUserId").val();
		//alert("find " + userId);
		
		var loginData = {"loginId":$("#loginId").val(), "password": $("#password").val()};

		$.ajax({
			// url : 'rest/user/' + userId,
			url : 'rest/user/login',
			type : 'post',
			 //dataType : 'json',
			contentType : "application/x-www-form-urlencoded; charset=utf-8",
			//contentType : 'application/json; charset=utf-8',
			//data: JSON.stringify(loginData),
			data:loginData,
			success : function(data, textStatus, request) {
				$("#loginCard").hide();
				$("#signCard").hide();
				$("#welcomeCard").show();
				$("#navCard").show();
				userData = data;
		
				$("<b/>").text("Welcome " +data.userLoginId).appendTo($("#welcomeLabel"));
				//$("#welcomeLabel").text("Welcome " +data.userName);
				//alert(request.getResponseHeader('Authorization'));
                if(window.sessionStorage) { 
                    sessionStorage.setItem("Authorization", request.getResponseHeader('Authorization'));
                }
			},
			statusCode: {
			      401:function() {$("#loginError").show();}
			}
		});
	});


	
	$("#createBlog").click(function(e) {
		event.preventDefault();
		$("#blogCard").show();
		$("#listingCard").hide();
		

	});
	
	$("#searchIcon").click(function(e) {
		
			var searchStr = $("#search").val();
				$.ajax({
					url : 'rest/blog?searchStr='+ searchStr,
					type : 'get',
					dataType : 'json',
					contentType: "application/json; charset=utf-8",
					success : function(data, jqXHR) {
						$("#listingCard").hide();
						
						

						
						var clist = $('ul.mylist');
						$('ul.mylist').empty();
						$("#listingCard").show();
						if(jqXHR === "nocontent"){
							  var a = $('<h1>')
						        .text("No blogs found" )
						        .appendTo(clist);
						    
						   
							return;
						}
						//alert(data.status);
						
						//alert(blogs);
						

						var blogs = data;
						var cList = $('ul.mylist')
						$.each(blogs, function(i) {
						    var li = $('<li/>')
						        .appendTo(cList);
						    $('<br/>')
						    .appendTo(li);
						    $('<br/>')
						    .appendTo(div);
						    
						 var div=   $("<div/>") 
						    	.addClass('w3-card-4')
						    	.click(function(e){
					    		$("#listingCard").hide(),
					    		$("#viewCard").show(),
					    	
					    		$("#title3").text(data[i].blogTitle )
					    		$("#body3").text(data[i].blogBody)
					    	})
						    	.appendTo(li);
						    	
					
						    
						    var a = $('<h3>')
						        .text( data[i].blogTitle ).addClass("w3-container")
						        .appendTo(div);
						    
						   
						    
						    var line = $('<br/>')
						   
					
//						    var a1 = $('<label/>')
//						    .css({"white-space":"normal"},
//						    {"width": "12em"} ,
//						    {"height": "3em"} ,
//						    {"overflow": "hidden"},
//						    {"text-overflow":"ellipsis"})
//						    .text( data[i].blogBody).addClass("w3-container")
//						    .appendTo(div);
						    
						    var a1 = $('<h6/>')
					
					        .text( data[i].blogBody).addClass("w3-container ell")
					        .appendTo(div);
				    
					    //var blogsData=blog;
						    
						});
						
					
						
					},
				});
	});
	
	$("#signInButton").click(function(e) {
		event.preventDefault();
		$("#loginCard").show();
		$("#signUpCard").hide();

	});
	
	
	$("#cancelViewBlogButton").click(function(e) {
		event.preventDefault();
		$("#listingCard").show();
		$("#viewCard").hide();

	});
	
	$("#signInButton").click(function(e) {
		event.preventDefault();
		$("#loginCard").show();

	});
	
	$("#signUpButton").click(function(e) {
	
		event.preventDefault();
		$("#signUpCard").show();
		$("#loginCard").hide();

	});	
	
	$("#loginCancelButton").click(function(e) {
		
		event.preventDefault();
		$("#loginCard").hide();

	});
	
	$("#signUpCancelButton").click(function(e) {
		
		event.preventDefault();
		$("#signUpCard").hide();

	});	
	

	$("#createBlogButton").click(function() {
		event.preventDefault();
		var body = $("textarea#body").val();
		var title = $("#title").val();
		//var hashTag = $("#hashTag").val();
		
		var blog = {
			"blogTitle" : title,
			"blogBody" : body,
			"user" : {"userLoginId": userData.userLoginId}
		};
		$.ajax({
			url : 'rest/blog',
			type : 'post',
			//dataType : 'json',
			contentType: "application/json; charset=utf-8",
			data : JSON.stringify(blog),
			 beforeSend: function(xhr) {
				 	 if(window.sessionStorage) { 
				 		xhr.setRequestHeader('Authorization', sessionStorage.getItem("Authorization"));
		               }
		      },
			success : function() {
				$("#blogCard").hide();
				$("#listingCard").show();
				
				reload();
			},
			
		});
		
	});
	
	$("#cancel").click(function() {
		$("#blogCard").hide();
		$("#listingCard").show();
	});
	
	
	$("#deleteUserButton").click(function(e) {
		event.preventDefault();

		//$("#findUser").hide();
		var userId = $("#deleteUserId").val();
		$.ajax({
			// url : 'rest/user/' + userId,
			url : 'rest/user/' + userId,
			type : 'delete',
			 //dataType : 'json',
			 contentType : "application/json; charset=utf-8",
			success : function(data) {
				//alert("User Deleted");
			}
		}).error(ajaxError);
	});
	
	$("#list").click(function() {
		
		event.preventDefault();
		//alert(xhr.getResponseHeader('Header'));
		//alert($window.sessionStorage.accessToken);
		//$("#findUser").hide();
		//var userId = $("#findUserId").val();
		//alert("find " + userId);
		//alert("get data");
		$.ajax({
			// url : 'rest/user/' + userId,
			url : 'rest/blog',
			type : 'get',

     		//Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI0MjM2LCJleHAiOjE0OTU1MjUxMzZ9.GJoS7h4pALs_XenfAU7_PKN1YwvYAdoUjlFgHJej67D2a0MnnXlX9F5b6DL_RIQv-VvmE63UZliDrxjsA5ZscA
			//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MDc0LCJleHAiOjE0OTU1Mjk5NzR9.knKbZ2IEoTFQc7Nkp9mbqS6vwSot2YOUSZPQzJsXhuIRdhihJ9MOvygw86845TEZhqAv7pvMPNgvH7E6YoXVIg
			//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MjQ5LCJleHAiOjE0OTU1MzAxNDl9.89Zrc7Gz6bBiAap8Pz_0Vq_p07bGYoPnqi0jwV4A1_n9Q2FMK6BeBxWWBBWhq4_8v0pvUuHWAatHlHxeVK_gsQ
			 dataType : 'json',
			 contentType : "application/json; charset=utf-8",
			 beforeSend: function(data) {
				 	//alert('setting beaer');
				    //alert(xhr.getRequestHeader('Authorization'));
				 	//alert(xhr.getResponseHeader('Authorization'));
//				 	 if(window.sessionStorage) { 
//		                    alert(sessionStorage.getItem("Authorization"));
//		                }
				    //alert(request.getResponseHeader('Authorization'));
			        //xhr.setRequestHeader('Authorization', sessionStorage.getItem("Authorization"));
				 	//xhr.setRequestHeader('Authorization', "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2Jsb2dnZXIvcmVzdC91c2VyL2xvZ2luIiwiaWF0IjoxNDk1NTI5MDc0LCJleHAiOjE0OTU1Mjk5NzR9.knKbZ2IEoTFQc7Nkp9mbqS6vwSot2YOUSZPQzJsXhuIRdhihJ9MOvygw86845TEZhqAv7pvMPNgvH7E6YoXVIg");
			//		var txt2 = $("<div/>").text("This id dynamic div ");    // Create with jQuery
				//    $('#myTable tr:last').after('<tr><td>'+txt2.html()+'</td></tr>');

		      },
			success : function(data) {

					//alert(data[0].blogTitle);
					
					$.each(data, function( index, value ) {
						 var blogDetails = $("<div/>").text("simple text");
						  //var blogDetails = $("<div/>").text("<table><tr><td>" + value.blogTitle + "</td></tr><tr><td>" + value.blogBody + "</td></tr><tr><td>" + UserName + "</td></tr> </table>");    // Create with jQuery
						  //alert(blogdetails); 
						  //$('#listtable tr:last').after('<tr><td>'+blogDetails.html()+'</td></tr>');
						  
						    //var txt2 = $("<div/>").text(value.blogTitle);    // Create with jQuery
						// var txt2=$("<div/>").text("<table><tr><td>" + value.blogTitle + "</td></tr><tr><td>" + value.blogBody + "</td></tr><tr><td>UserName</td></tr> </table>");    // Create with jQuery
						 //$('#myTable tr:last').after('<tr><td>'+txt2.html()+'</td></tr>');
						    
//						 var $table = $('<table/>');
//						 for(var i=0; i<3; i++){
//						     $table.append( '<tr><td>' + 'result' +  i + '</td></tr>' );
//						 }
//						 $('#myTable').append($table);
						 
						    jQuery('<div/>', {
						    	id: 'abcd',
						        href: 'http://google.com',
						        title: 'Become a Googler',
						        rel: 'external',
						        text: value.blogTitle,
						    }).appendTo('#myTable tr:last');

						});
					

			}
		}).error(ajaxError);

		
	});
	$("#registerButton").click(function() {
		event.preventDefault();
		// $("#addUser").hide();
		var userId = $("#signUpLoginId").val();
		var name = $("#signUpUserName").val();
		var email = $("#signUpEmail").val();
		var pwd = $("#signUpPassword").val();
		
		var user = {
			"userLoginId" : userId,
			"fullName" : name,
			"email" : email,
			"password" : pwd
		};
		$.ajax({
			url : 'rest/user',
			type : 'post',
			dataType : 'json',
			contentType : 'application/json; charset=utf-8',
			data : JSON.stringify(user),
			success : function(result, status, xhr) {
				$("#signUpCard").hide();
				$("#signCard").hide();
				$("#welcomeCard").show();
				$("#navCard").show();
			//	alert(result.userLoginId);
				userData=result;
				
				$("<b/>").text("Welcome " +result.userLoginId).appendTo($("#welcomeLabel"));
				//$("#welcomeLabel").text("Welcome " +data.userName);
			//	alert(xhr.getResponseHeader('Authorization'));
                if(window.sessionStorage) { 
                    sessionStorage.setItem("Authorization", xhr.getResponseHeader('Authorization'));
                }
			}
		}).error(ajaxError);
	});

});





function ajaxError(jqXHR, textstatus, errorThrown) {

	alert("errorThrown: " + errorThrown + " textstatus: " + textstatus
			+ " jqXHR: " + jqXHR)
}

//***** BlogPost Related



