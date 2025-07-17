/**
 * 
 */

console.log("===> join");

window.onload = function() {
	//console.log("=====> window.onload");
	
	setEventListener();
}

function setEventListener() {
	//console.log("=====> setEventListener");
	
	// 회원가입
	document.getElementById("btn-join").addEventListener("click", async function() {
		let email = document.getElementById("email").value;		
		let name = document.getElementById("name").value;
		let password = document.getElementById("password").value;
		let confirmPassword = document.getElementById("confirmPassword").value;
		let url;
		let option;
		let data = {
			"email": "",
			"name": "",
			"password": ""
		}
		let response;

		//console.log("commonCsrfToken = " + commonCsrfToken);
		//console.log("email = " + email + ", " + email.length);
		//console.log("name = " + name + ", " + name.length);
		//console.log("password = " + password + ", " + password.length);
		//console.log("confirmPassword = " + confirmPassword + ", " + confirmPassword.length);
		
		// 이메일, 이름, 패스워트 문자패턴 검증 필요		

		// 입력 패스워드 비교
		if (password === confirmPassword) {
			// 맞음
			url = "/api/join/join";
			option = {
				method: "POST",
				headers: {
					[commonCsrfHeader]: commonCsrfToken,
					"Content-Type": "application/json",
				},
			}
			data.email = email;
			data.name = name;
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
				location.replace("/join"); // 현재페이지
			}
		} else {
			alert("패스워드가 정확한지 확인하세요.");
		}
	});
}


