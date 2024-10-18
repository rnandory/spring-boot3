// new Promise();

// 라이브러리 or api
function drive(eventHandler, successHandler) {

    // 사고감지. but 조치는 안해. 날 호출하는 함수가 조치.
    setTimeout(eventHandler, 3000);

    setTimeout(successHandler, 5000);
}

// drive() 중 사고나면 전화해!
drive(function() {
    console.log("119전화해");
},
function() {
    console.log("완주햇다")
});