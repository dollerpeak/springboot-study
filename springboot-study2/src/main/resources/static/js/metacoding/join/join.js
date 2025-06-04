/**
 * 
 */

// gloval
//let gValue = "global value";

//$(document).ready(function(){
//	console.log(">>> 0.document.ready");
//	//console.log("g_value = ", gValue);
//})

$(function() {
	console.log(">>> join");
	console.log(">>> 1.function");

	window.onload = function() {
		console.log(">>> 2.window.onload");

		setEventListener();
	}

	function setEventListener() {
		console.log(">>> setEventListener");

		let joinData = {
			name: "",
			password: "",
			email: "",
		};

		$("#btn-join").on("click", function() {
			//console.log("btn-login, click");
			joinData.name = $("#name").val();
			joinData.password = $("#password").val();
			joinData.email = $("#email").val();

			//console.log("joinData = ", joinData);
			console.log("joinData = ", JSON.stringify(joinData));

			if (joinData.name == null || joinData.name.length <= 0) {
				alert("Name를 입력해 주세요.");
			} else if (joinData.password == null || joinData.password.length <= 0) {
				alert("Password를 입력해 주세요.");
			} else if (joinData.email == null || joinData.email.length <= 0) {
				alert("Email을 입력해 주세요.");
			} else {

				$.ajax({
					type: "POST",
					url: "/metacoding/auth/rest/join/join",
					data: JSON.stringify(joinData),
					contentType: "application/json; charset=utf-8", // 요청데이터 형식
					dataType: "json" // 응답데이터 형식
				}).done(function(response) {
					console.log("done, response = ", JSON.stringify(response));
					if (response.data == null) {
						alert(response.message);
					} else {
						//joinData = response.data.object;
						//console.log("done, loginData = ", JSON.stringify(joinData));
						console.log("done, 회원가입 성공");
						alert(response.message);

						location.href = "/metacoding/home";
					}
				}).fail(function(error) {
					console.log("fail = ", JSON.stringify(error));
					alert("회원가입 실패");
					
					location.href = "/metacoding/join/join";
				});
			}
		})
	}


})


