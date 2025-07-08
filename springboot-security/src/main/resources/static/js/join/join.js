/**
 * 
 */

console.log(">>> join");

window.onload = function() {
	console.log(">>> window.onload");
	
	setEventListener();
}

function setEventListener() {
	console.log(">>> setEventListener");
	
	// 회원가입
	document.getElementById("btn-join").addEventListener("click", function() {
		let data = {
			"username": "",
			"password": ""
		}
		let username = document.getElementById("username").innerText;
		let password = document.getElementById("password").value;
		let confirmPassword = document.getElementById("confirmPassword").value;

		// 지금은 그냥 4자 이상 입력
		if (username.length < 4) {
			alert("아이디는 4자 이상 입력하세요.");
		}
		if (password.length < 4) {
			alert("패스워드는 4자 이상 입력하세요.");
		}	
		
		// 입력 패스워드 비교
		if(password === confirmPassword) {
			// 맞음
		} else {
			// 틀림
			alert("패스워드가 정확한지 확인하세요.");
		}

	});
}


