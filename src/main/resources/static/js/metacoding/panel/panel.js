/**
 * 
 */

// gloval
//let gValue = "global value";

//$(document).ready(function(){
//	console.log(">>> 0.document.ready");
//	//console.log("g_value = ", gValue);
//})
//
$(function() {
	console.log(">>> 1.function");

	window.onload = function() {
		console.log(">>> 2.window.onload");

		setEventListener();
	}

	function setEventListener() {
		console.log(">>> setEventListener");

		let panelData = {
			id: "",
			title: "",
			contents: "",
			hits: "",
			userId: "",
			frstRegDate: "",
			frstRegUserId: "",
			lastChgDate: "",
			lastChgUserId: ""
		};
		let panelDataList = new Array()

		$("#btn-insert").on("click", function() {
			//console.log("btn-insert, click");
			panelData.title = $("#title").val();
			panelData.contents = $("#contents").val();

			//console.log("panelData = ", panelData);
			console.log("panelData = ", JSON.stringify(panelData));

			if (panelData.title == null || panelData.title.length <= 0) {
				alert("title을 입력해 주세요.");
			} else if (panelData.contents == null || panelData.contents.length <= 0) {
				alert("contents를 입력해 주세요.");
			} else {

				$.ajax({
					type: "POST",
					url: "/metacoding/panel/insertPanel",
					data: JSON.stringify(panelData),
					contentType: "application/json; charset=utf-8", // 요청데이터 형식
					dataType: "json" // 응답데이터 형식
				}).done(function(response) {
					//console.log("done, response = ", JSON.stringify(response));
					if (response.data == null) {
						alert(response.message);
					} else {
						//panelData = response.data.list;
						//console.log("done, panelData = ", JSON.stringify(response.data.list));
						console.log("done, panelData = ", JSON.stringify(response.data.list[0]));
						panelDataList.push(response.data.list[0]);
						console.log("done, panelDataList = ", JSON.stringify(panelDataList[0]));
						console.log("done, 글저장 성공");
						alert(response.message);
						
						location.href = "/metacoding/home";
						//location.href = "http://localhost:8082/receiver";						
					}
				}).fail(function(error) {
					console.log("fail = ", JSON.stringify(error));
					alert("글저장 실패");
					
					location.href = "/metacoding/panel/panelForm";
				});
			}
		})
	}


})


