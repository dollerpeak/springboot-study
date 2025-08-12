/**
 * 
 */

console.log("===> category");

window.onload = function() {
	//console.log("=====> window.onload");

	setEventListener();
	
	init();
}

function setEventListener() {
	//console.log("=====> setEventListener");
}

function init() {
	selectCatogory();
}

async function selectCatogory() {
	let url;
	let option;
	let data;
	let response;
	
	url = "/api/category/select";
	option = {
		method: "GET",
		headers: {
			[commonCsrfHeader]: commonCsrfToken,
			"Content-Type": "application/json",
		},
	}

	// 비동기로 받아야 로그출력이 가능
	response = await commonFetch(url, option, data);
	//console.log("response = " + response);

	// 의도하지 않은 에러
	if (response == null) {
		location.replace("/fail"); // 에러페이지
	} else {
		//console.log("response = " + JSON.stringify(response));
		if (response.code == 200) {
			console.log("response.data.list = " + JSON.stringify(response.data.list));
		} else {
			// 의도한 에러
			commonError(response);
		}
	}
}


