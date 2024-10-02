var util = require("./util.js");
var util2 = require("./util2.js");

// es6부터 추가된 esm방식
// import aa from "./util.js";
// var s = aa(3,5);
// console.log(s);


var s = util.sum(3,5);
console.log(s);




console.log(new util2().calc(1,2));

console.log(util);
console.log(new util.Calc().calc(2,3));

var newlec = require("newlec-hello");
console.log(newlec.hello());