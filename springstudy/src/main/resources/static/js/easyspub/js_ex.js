
let heading = document.querySelector("#heading");

heading.onclick = function () {    
    let color = heading.style.color;
    if (color == "red") {
        heading.style.color = "green";
    } else {
        heading.style.color = "red";
    }

    //console.log(typeof color);
}

// test 1
function changeColor_1(color) {
    let bg = document.querySelector("#bg");
    bg.style.backgroundColor = color;
}

// test 2
// let chgButton = document.querySelector("#change");
// chgButton.onclick = changeColor_2;

// test 3
// document.querySelector("#change").onclick = changeColor_2;
// function changeColor_2() {
//     let bg = document.querySelector("#test2");
//     bg.style.color = "green";
// }

// test 4
document.querySelector("#change").onclick = function() {
    let bg = document.querySelector("#test2");
    bg.style.color = "blue";
}

window.onload = function(){
    console.log("www1111111111");
    cadit()
}

function cadit(){
	console.log("test start")
	
	//for (let i = 0; i < 2; i++) {
		a1 = [1, 1, 1];
		a2 = [4, 5, 6];

		result = a1.map(function(num, idx) {
			console.log("num = " + num + ", idx = " + idx+ ", a2[idx] = " + a2[idx]);
			return num + 1 * a2[idx];
		});
	//}

	console.log("result = " + result);
	
	//num = 1, idx = 0, a2[idx] = 4
	//num = 2, idx = 1, a2[idx] = 5
	//num = 3, idx = 2, a2[idx] = 6
	//result = 5,7,9
	
}


document.addEventListener("DOMcontentLoaded", function (){
    console.log("1111111111");
});

