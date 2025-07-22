/**
 * 
 */
console.log("===> common");

let commonCsrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
let commonCsrfHeader = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');
//let commonAuthName = document.querySelector('meta[name="auth-name"]').getAttribute(content);
//let commonAuthRole = document.querySelector('meta[name="auth-role"]').getAttribute(content);

/*
사용예제
let url = "/aloha/blog/multipart/insert";
let option = {
	method: "POST", // *GET, POST, PUT, DELETE
	//mode: "cors", // no-cors, *cors, same-origin
	//cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
	//credentials: "same-origin", // include, *same-origin, omit
	headers: {
		"Content-Type": "application/json"
		// "Content-Type": "application/x-www-form-urlencoded",
	},
	//redirect: "follow", // manual, *follow, error
	//referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
}
*/
async function commonFetch(url, option, data) {
	//console.log("===> commonFetch");

	try {
		let response = await fetch(url, {
			method: option.method,
			headers: option.headers,
			body: JSON.stringify(data),
		});
		console.log("response.status = " + response.status);
		// response.json() 한번 읽으면 다시 읽을 수 없음

		// 여기서 판단하지 않고 받는 쪽에서 판단
		return await response.json();
		
		//if (response.status == 200) {
		//	return await response.json();
		//} else {
		//	// 에러메세지 생성
		//	throw new Error("response.status = " + response.status);
		//}
	} catch (error) {		
		//console.error("url = " + url);
		//console.error("option = " + JSON.stringify(option));
		//console.error("data = " + JSON.stringify(data));
		
		// 생성된 에러메세지 출력
		//alert(error);
		return null;
	}
}


function commonError(response) {
	//console.log("===> commonError");

	let error = true;	
	let url;
	let params;
	
	if (response.data != null && response.data.url != null) {
		error = false;
	}
	
	if (error == true) {
		// get
		url = "/fail/error";
		params = new URLSearchParams({
			code: response.code,
			title: response.title,
			message: response.message,
			log: response.log
		}).toString();

		//console.log("url = " + url);
		//console.log("params = " + params);

		//location.href = `${url}?${params}`; // 뒤로가기 가능
		location.replace(`${url}?${params}`); // 뒤로가기 불가
	} else {
		alert(response.title + "\n" + response.message);
		//location.replace(response.data.url); // 뒤로가기 가능
		location.replace(response.data.url); // 뒤로가기 불가
	}
}




