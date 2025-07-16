/**
 * 
 */

console.log(">>> custom login");
let csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
let csrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

window.onload = function() {
	console.log(">>> window.onload");
	
	setEventListener();
}

function setEventListener() {
	console.log(">>> setEventListener");
	
	// 로그인
	document.getElementById("btn-login").addEventListener("click", async function() {
		let email = document.getElementById("email").value;
		let password = document.getElementById("password").value;
		let url;
		let option;
		let data = {
			"email": "",
			"password": ""
		}
		let response;

		//console.log("csrfToken = " + csrfToken);
		//console.log("email = " + email + ", " + email.length);
		//console.log("password = " + password + ", " + password.length);	
		
		// 이메일 문자패턴 검증 필요	

		// 입력 패스워드 비교
		if (email.length > 0 && password.length > 0) {
			url = "/api/custom/login";
			option = {
				method: "POST",
				headers: {
					[csrfHeader]: csrfToken,
					"Content-Type": "application/json",
				},
			}
			data.email = email;
			data.password = password;

			// 비동기로 받아야 로그출력이 가능
			response = await commonFetch(url, option, data);
			console.log("response = " + JSON.stringify(response));

			if (response.code == 200) {
				alert(response.title + "\n" + response.message);
				//location.href = response.data.url; // 뒤로가기 가능
				location.replace(response.data.url); // 뒤로가기가 안됨
			} else {
				alert(response.title + "\n" + response.message);
				//alert(response.message + "\n" + response.log);
				location.replace("/login"); // 현재페이지
			}
		} else {
			alert("이메일과 패스워드를 입력해 주세요.");
		}
	});
}


