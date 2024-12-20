/**
 * 
 */

// gloval
//let gValue = "global value";

//$(document).ready(function(){
//	console.log(">>> 0.document.ready");
//	//console.log("g_value = ", gValue);
//})

$(function(){
	console.log(">>> 1.function");
	
	window.onload = function(){		
		console.log(">>> 2.window.onload");
		
		setEventListener();
	}
	
	function setEventListener(){
		console.log(">>> setEventListener");
		
		$("#btn-login").on("click", function(){
			//console.log("btn-login, click");
			let loginData = {
				name: $("#name").val(),
				password: $("#password").val(),
			};

			//console.log("loginData = ", loginData);
			console.log("loginData = ", JSON.stringify(loginData));
			
			$.ajax({
				type: "POST",
				url: "/metacoding/login/rest/login",
				data: JSON.stringify(loginData),
				contentType: "application/json; charset=utf-8", // 요청데이터 형식
				dataType: "json" // 응답데이터 형식
			}).done(function(response){
				console.log("ajax, success = ", JSON.stringify(response));
				location.href = "/metacoding/home";
				alert("로그인완료");
			}).fail(function(error){
				//console.log("ajax, fail = ", error);
				console.log("ajax, fail = ", JSON.stringify(error));
				location.href = "/metacoding/login/login";
				alert("로그인실패");
			});
			
		})
	}
	
	
})

 
 