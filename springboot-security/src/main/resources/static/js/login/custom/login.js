/**
 * 
 */

console.log("===> custom login");

window.onload = function() {
	//console.log("=====> window.onload");
	
	setEventListener();
}

function setEventListener() {
	//console.log("=====> setEventListener");
	
	// 로그인
	document.getElementById("btn-login").addEventListener("click", async function() {
		let emailPatten = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		
		let email = document.getElementById("email").value;
		let password = document.getElementById("password").value;
		
		let url;
		let option;
		let data = {
			"email": "",
			"password": ""
		}
		let response;

		//console.log("commonCsrfToken = " + commonCsrfToken);
		//console.log("email = " + email + ", " + email.length);
		//console.log("password = " + password + ", " + password.length);

		if (email.length > 0 && password.length > 0) {
			if (emailPatten.test(email) == true) {
				//url = "/api/custom/login";
				url = "/api/login";
				option = {
					method: "POST",
					headers: {
						[commonCsrfHeader]: commonCsrfToken,
						"Content-Type": "application/json",
					},
				}
				data.email = email;
				data.password = password;

				// 비동기로 받아야 로그출력이 가능
				response = await commonFetch(url, option, data, false);

				// 의도하지 않은 에러
				if (response == null) {
					location.replace("/fail"); // 에러페이지
				} else {
					//console.log("response = " + JSON.stringify(response));
					if (response.code == 200) {
						alert(response.title + "\n" + response.message);
						//location.href = response.data.url; // 뒤로가기 가능
						location.replace(response.data.url); // 뒤로가기가 안됨
					} else {
						// 의도한 에러 : 알림창 처리만
						alert(response.title + "\n" + response.message);
						//location.replace("/custom/login"); // 현재페이지
						location.replace("/login"); // 현재페이지
						//commonError(response);
					}
				}
			} else {
				alert("이메일 형식이 올바르지 않습니다.");
			}
		} else {
			alert("로그인 정보를 입력하세요.");
		}
	});
}


