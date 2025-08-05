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
		let emailPatten = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

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
		
		if (email.length > 0 && name.length > 0 && password.length > 0 && confirmPassword.length > 0) {
			if (emailPatten.test(email) == true) {
				if (password === confirmPassword) {
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
					//console.log("response = " + response);

					// 의도하지 않은 에러
					if (response == null) {						
						location.replace("/fail"); // 에러페이지
					} else {
						//console.log("response = " + JSON.stringify(response));
						if (response.code == 200) {
							//console.log("response.data.object.email = " + response.data.object.email);
							// 성공메세지
							alert(response.title + "\n" + response.message);
							// 성공페이지
							//location.href = response.data.url; // 뒤로가기 가능
							location.replace(response.data.url); // 뒤로가기 불가
						} else {
							// 의도한 에러
							commonError(response);
						}
					}
				} else {
					alert("패스워드가 정확한지 확인하세요.");
				}
			} else {
				alert("이메일 형식이 올바르지 않습니다.");
			}
		} else {
			alert("회원가입 정보를 입력하세요.");
		}
	});
}


