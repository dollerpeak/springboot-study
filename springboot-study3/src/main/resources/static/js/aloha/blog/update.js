/**
 * 
 */

//(function(){
//window.onload = function() {
	
//let form = document.getElementById("form");
/*
document.getElementById("btn-update").addEventListener("click", function(){
	... 기능 ...	
})*/

function update() {
	let id = document.getElementById("id").value;
	let title = document.getElementById("title").value;
	let content = document.getElementById("content").value;
	
	let data = {
		"id": id,
		"title": title,
		"content": content,
	}
	console.log(data);
	
	
	// 응답 확인
	let request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		// 요청 성공
		if (request.readyState == request.DONE && request.status == 200) {
			let response = request.responseText;
			alert(response);
			//console.log(response);
			if(response == "success"){
				location.href = "/aloha/blog/select"
			}
		}

		// 요청 실패
		if (request.readyState == request.DONE && request.status == 400) {
			let response = request.responseText;
			alert(response);
		}

		// 에러 발생
		if (request.readyState == request.DONE && request.status == 500) {
			alert('서버측 에러 발생');
		}
	}

	// 요청 설정
	let url = "/aloha/blog/update";
	request.open("PUT", url, true);
	request.setRequestHeader("Content-Type", "application/json");

	// JSON.stringify() : JavaScript 의 객체를 JSON 문자열로 변환하는 메소드
	request.send(JSON.stringify(data));
	
	
	// fetch 사용
	/*
	fetchPost("/aloha/blog/update", data).then(jsonData => {
		console.log(jsonData);	
	})
	*/
}

async function fetchPost(url, data) {
	try {
		let response = await fetch(url, {
			method: "PUT",
			headers: {
				"Content-Type": "application/json"
			},
			//body: JSON.stringify({data}),
			body: JSON.stringify(data),
		});
		
		if(response.status == 200) {
			return await response.json();
		} else {
			throw new Error("response.status error = " + response.status);
		}
	} catch (error) {
		console.error(error);
	    alert("데이터를 불러오는 중 문제가 발생했습니다.\n" + error);
	    return null;
	}
}

function remove() {
	let id = document.getElementById("id").value;	
	console.log("id = " + id);
	
	// 응답 확인
	let request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		// 요청 성공
		if (request.readyState == request.DONE && request.status == 200) {
			let response = request.responseText;
			alert(response);
			//console.log(response);
			if(response == "success"){
				location.href = "/aloha/blog/select"
			}
		}

		// 요청 실패
		if (request.readyState == request.DONE && request.status == 400) {
			let response = request.responseText;
			alert(response);
		}

		// 에러 발생
		if (request.readyState == request.DONE && request.status == 500) {
			alert('서버측 에러 발생');
		}
	}

	// 요청 설정
	let url = "/aloha/blog/delete?id=" + id;
	request.open("DELETE", url, true);
	//request.setRequestHeader("Content-Type", "application/json");

	// JSON.stringify() : JavaScript 의 객체를 JSON 문자열로 변환하는 메소드
	request.send();
}
//}
//});





