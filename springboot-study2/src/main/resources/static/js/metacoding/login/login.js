/**
 * 
 */

// gloval
//let gValue = "global value";

//$(document).ready(function(){
//	console.log(">>> 0.document.ready");
//	//console.log("g_value = ", gValue);
//})
//
$(function() {
	console.log(">>> login");
	console.log(">>> 1.function");

	window.onload = function() {
		console.log(">>> 2.window.onload");

		setEventListener();
	}

	function setEventListener() {
		console.log(">>> setEventListener");

		let loginData = {
			name: "",
			password: "",
		};

		$("#btn-login").on("click", function() {
			//console.log("btn-login, click");
			loginData.name = $("#name").val();
			loginData.password = $("#password").val();

			//console.log("loginData = ", loginData);
			console.log("loginData = ", JSON.stringify(loginData));

			if (loginData.name == null || loginData.name.length <= 0) {
				alert("Name를 입력해 주세요.");
			} else if (loginData.password == null || loginData.password.length <= 0) {
				alert("Password를 입력해 주세요.");
			} else {

				$.ajax({
					type: "POST",
					//url: "/metacoding/login/rest/login",
					url: "/metacoding/auth/login/login",
					data: JSON.stringify(loginData),
					contentType: "application/json; charset=utf-8", // 요청데이터 형식
					dataType: "json" // 응답데이터 형식
				}).done(function(response) {
					console.log("done, response = ", JSON.stringify(response));
					if (response.data == null) {
						alert(response.message);
					} else {
						//loginData = response.data.object;
						//console.log("done, loginData = ", JSON.stringify(loginData));
						console.log("done, 로그인 성공");
						alert(response.message);
						
						location.href = "/metacoding/home";
						//location.href = "http://localhost:8082/receiver";						
					}
				}).fail(function(error) {
					console.log("fail = ", JSON.stringify(error));
					alert("로그인 실패");
					
					location.href = "/metacoding/login/login";
				});
			}
		})
	}


})


