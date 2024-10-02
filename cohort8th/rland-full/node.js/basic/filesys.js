// node 내장 api filesystem api import
var fs = require('node:fs');

// 동기형 api
var data = fs.readFileSync('data.txt');
console.log(data.toString("utf-8"));

// 비동기형 api
var data1 = fs.readFile("data.txt", function(err, data) {
    console.log(data.toString("utf-8"));
});

console.log("끝");