/**
 * 
 */

console.log("===> product insert");

window.onload = function() {
	//console.log("=====> window.onload");

	init();
	setEventListener();
}

async function init() {	
	let url = "/api/category/select";
	let option = {
		method: "POST",
		headers: {
			[commonCsrfHeader]: commonCsrfToken,
			"Content-Type": "application/json",
		},
	}
	let data;

	// 비동기로 받아야 로그출력이 가능
	response = await commonFetch(url, option, data, false);

	// 의도하지 않은 에러
	if (response == null) {
		location.replace("/fail"); // 에러페이지
	} else {
		if (response.code == 200) {
			//console.log("response = " + JSON.stringify(response));
			let categoryHTML = document.getElementById("category");
			
			// case 1 : html문법을 알기 어려움
			//response.data.list.forEach(data => {
			//	//console.log("data = " + JSON.stringify(data));
			//	//console.log("data.id = " + data.id);
			//	let html = document.createElement("option");
			//	html.value = data.id;				
			//	html.textContent = data.name;
			//	categoryHTML.appendChild(html);
			//});
			
			// case 2 : 기존 HTML을 그대로 적용
			categoryHTML.innerHTML = `<option value="">카테고리를 선택하세요</option>`;
			response.data.list.forEach(data => {
				categoryHTML.innerHTML += `<option value="${data.id}">${data.name}</option>`;
			});
		} else {
			//location.replace("/main/main");
			commonError(response);
		}
	}
}

function setEventListener() {
	//console.log("=====> setEventListener");

	// 상품등록
	document.getElementById("form").addEventListener("submit", async function(e) {		
		
		// 브라우저 기본 동작 중단 (submit시 데이터 전송)
		// - 기본 데이터 전송을 하지 말고 아래 fetch로 전송
		e.preventDefault();		
		
		let numberPatten = /^\d+$/;
		let imageCheck;
		
		let categoryId = document.getElementById("category").value;
		let sold = document.getElementById("isSold").value;
		let name = document.getElementById("productName").value.trim();
		let price = document.getElementById("price").value;
		let description = document.getElementById("description").value.trim();
		let thumbnailImage = document.getElementById("thumbnail").files[0];
		let detailImages = document.getElementById("detailImages").files;
		//console.log("categoryId = " + categoryId);
		//console.log("sold = " + sold);
		//console.log("name = " + name);
		//console.log("price = " + price);
		//console.log("description = " + description);
		//console.log("thumbnailImage.length = " + thumbnailImage.length);
		//console.log("thumbnailImage = " + thumbnailImage.name);
		//console.log("detailImages.length = " + detailImages.length);
		//console.log("detailImages = " + detailImages[0].name);
		
		// 판매여부 체크
		if (sold.length <= 0) {
			alert("판매여부를 선택하세요.");
			return;
		}
		// 카테고리 체크
		if (categoryId.length <= 0) {
			alert("카테고리를 선택하세요.");
			return;
		}
		// 상품명 체크
		if (name.length <= 0) {
			alert("상품명을 입력하세요.");
			return;
		}
		// 가격 체크
		if (price.length <= 0) {
			alert("가격을 입력하세요.");
			return;
		} else {
			if (numberPatten.test(price) == true) {
				//
			} else {
				alert("입력하신 가격을 확인해 주세요.");
				return;
			}
		}
		// 썸네일 체크
		if (thumbnailImage.length <= 0) {
			alert("썸네일 이미지를 업로드하세요.");
			return;
		} else {
			if (thumbnailImage.length > 1) {
				alert("썸네일 이미지는 최대 1개까지만 선택 가능합니다.");
				return;
			} else {
				imageCheck = await commonImageCheck(thumbnailImage, -1, 492, 492);
				if (imageCheck != 1) {
					if (imageCheck == 4) {
						alert("썸네일의 파일 확장자를 확인해 주세요.");
						return;
					} else if (imageCheck == 3) {
						alert("썸네일의 용량을 확인해 주세요.");
						return;
					} else {
						alert("썸네일의 가로세로 사이즈를 확인해 주세요.");
						return;
					}
				}
			}
		}
		// 상품설명 체크
		// - 따로 체크하지 않는다.
		// 상세이미지 체크
		if (detailImages.length <= 0) {
			alert("상세 이미지를 업로드하세요.");
			return;
		} else {
			if (detailImages.length > 3) {
				alert("상세 이미지는 최대 3개까지만 선택 가능합니다.");
				return;
			} else {
				for (let file of detailImages) {					
					imageCheck = await commonImageCheck(file, -1, 780, -1);
					if (imageCheck != 1) {
						if (imageCheck == 4) {
							alert("상세 이미지의 파일 확장자를 확인해 주세요.");
							return;
						} else if (imageCheck == 3) {
							alert("상세 이미지의 용량을 확인해 주세요.");
							return;
						} else {
							alert("상세 이미지의 가로세로 사이즈를 확인해 주세요.");
							return;
						}
					}
				}
			}
		}
		

		let formData = new FormData();
		let productDto = {
			categoryId: categoryId,
			sold: sold,			
			name: name,
			price: price,
			description: description
		};		
		//console.log("productDto = " + JSON.stringify(productDto));

		// formData append
		formData.append(
			"productDto",
			new Blob([JSON.stringify(productDto)], { type: "application/json" })
		);
		formData.append("thumbnailImage", thumbnailImage);
		for (let i = 0; i < detailImages.length; i++) {
			formData.append("detailImages", detailImages[i]);
		}
		  
		let url;
		let option;
		let data;
		let response;
		
		url = "/api/seller/product/insert";
		option = {
			method: "POST",
			headers: {
				[commonCsrfHeader]: commonCsrfToken,
				// "Content-Type": "application/json", // multipart/form-data 사용하면 안됨 
			},
		}
		data = formData;

		// 비동기로 받아야 로그출력이 가능
		response = await commonFetch(url, option, data, true);
		//console.log("response = " + response);

		// 의도하지 않은 에러
		// - global exception에 적용되면 어떤 경우든 response.status 값은 가지게 됨
		// - 그럼 그외적인 경우가 있을가 싶긴한데 어쨋든 의도되지 않은 에러
		if (response == null) {
			//console.log("response = null");
			location.replace("/fail"); // 에러페이지
		} else {
			//console.log("response = " + JSON.stringify(response));
			if (response.code == 200) {
				// 성공메세지
				//alert(response.title + "\n" + response.message);
				// 성공페이지
				//location.href = response.data.url; // 뒤로가기 가능
				//location.replace(response.data.url); // 뒤로가기 불가
			} else {
				// 의도한 에러, global exception 전체
				commonError(response);
			}
		}
	});
}


