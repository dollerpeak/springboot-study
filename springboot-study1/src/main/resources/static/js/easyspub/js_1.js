
document.addEventListener("DOMContentLoaded", function () {
    console.log("DOMContentLoaded");
})

window.onload = function () {
    console.log("window.onload");
}

window.onunload = function () {
    console.log("window.onunload");
}

// window
//case 1
// window.onload = function(){
//     console.log("window.onload");
// }
// window.onunload = function(){
//     console.log("window.onunload");
// }
// case 2
// window.onload = windowLoad;
// window.onunload = windowUnLoad;
// function windowLoad() {
//     console.log("windowLoad");
// }
// function windowUnLoad() {
//     console.log("windowUnLoad");
// }
// case 3
// window.addEventListener("load", function(){
//     console.log("addEventListener.load");
// })
// window.addEventListener("unload", function(){
//     console.log("addEventListener.unload");
// })
// case 4
// window.addEventListener("load", windowLoad);
// window.addEventListener("unload", windowUnLoad);
// function windowLoad() {
//     console.log("windowLoad 11");
// }
// function windowUnLoad() {
//     console.log("windowUnLoad 11");
// }

// document
//case 1
// document.addEventListener("DOMContentLoaded", function () {
//     console.log("DOMContentLoaded");
// })
//case 2
// document.addEventListener("DOMContentLoaded", documentContentLoaded);
// function documentContentLoaded() {
//     console.log("DOMContentLoaded");
// }
