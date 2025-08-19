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
async function commonFetch(url, option, data, multipart) {
	//console.log("===> commonFetch");

	try {
		let response;
		
		if (multipart == false) {
			// 일반 API
			response = await fetch(url, {
				method: option.method,
				headers: option.headers,
				body: JSON.stringify(data),
			});
		} else {
			// 파일 API
			response = await fetch(url, {
				method: option.method,
				headers: option.headers,
				body: data,
			});
		}
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
	
	// 의도한 에러에는 
	// - 실제로 에러 데이터를 만든 경우 
	// - globa exception중 custoException, generic 모두 포함
	
	// url까지 가지고 있다면
	// - 실제로 에러 데이터를 만든 경우 
	// - globa exception중 customException
	if (response.data != null && response.data.url != null) {
		error = false;
	}
	
	if (error == true) {
		// 의도된 에러 중 URL정보가 없는 경우, global exception중 generic
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
		// 의도된 에러 중 URL정보가 있는 경우
		alert(response.title + "\n" + response.message);
		//location.replace(response.data.url); // 뒤로가기 가능
		location.replace(response.data.url); // 뒤로가기 불가
	}
}

async function commonImageCheck(image, imageSizeMb, imageWidth, imageHeight) {
	//console.log("===> commonImageCheck");	

	return new Promise((resolve) => {
		let imageType = ["image/jpeg", "image/png", "image/gif"];

		if (false == imageType.includes(image.type)) {
			// 파일 타입 예외
			return resolve(4);
		} 
		
		// 이미지 사이즈 체크
		if (imageSizeMb != -1) {
			if (image.size > imageSizeMb * 1024 * 1024) {
				// 파일 용량 예외
				return resolve(3);
			}
		}
			
		let reader = new FileReader();
		reader.onload = function(e) {
			const img = new Image();
			img.onload = function() {
				let widthCheck = true;
				let heightCheck = true;

				// width
				if (imageWidth != -1) {
					if (img.width > imageWidth) {
						widthCheck = false;
					}
				}
				// height
				if (imageHeight != -1) {
					if (img.height > imageHeight) {
						heightCheck = false;
					}
				}

				// check
				if (widthCheck == false || heightCheck == false) {
					// 파일 사이즈 예외
					return resolve(2);
				} else {
					// 정상
					return resolve(1);
				}
			};
			img.src = e.target.result;
		};
		reader.readAsDataURL(image);
	});
}










