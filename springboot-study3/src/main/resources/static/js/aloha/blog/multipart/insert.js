/**
 * 
 */

window.onload = function() {
	console.log("window.onload");
	addEventListener();

}

function addEventListener() {
	console.log("addEventListener");
	
	document.getElementById("btn-insert").addEventListener("click", function() {
		console.log("btn-insert");
		let form = document.getElementById("form");
		console.log(form);
		
		form.submit();
		
		/*
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
		
		fetch(url, option, form);
		*/
		
		
	});
}

async function fetch(url, option, data) {
	try {
		let response = await fetch(url, {
			method: option.method,
			headers: option.headers,
			body: JSON.stringify(data),
		});
		console.error(response);
		console.error(response.status);

		if (response.status == 200) {
			return await response.json();
		} else {
			throw new Error("response.status error = " + response.status);
		}
	} catch (error) {
		console.error(error);
		alert(error);
		return null;
	}
}




