/**
 * 
 */

console.log("===> custom logout");

window.onload = function() {
	//console.log("window.onload");
	
	setEventListener();
}

function setEventListener() {
	//console.log("setEventListener");
	
	// 로그인
	document.getElementById("btn-logout").addEventListener("click", async function() {
		console.log("btn-logout");
		let url;
		let option;
		let data;
		let response;	

		url = "/api/custom/logout";
		option = {
			method: "POST",
			headers: {
				[commonCsrfHeader]: commonCsrfToken,
				"Content-Type": "application/json",
			},
		}

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
			location.replace("/"); // 현재페이지
		}
	});
}


