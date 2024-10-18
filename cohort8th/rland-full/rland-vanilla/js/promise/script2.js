// 라이브러리 or api
function getList(page) {

    return new Promise((resolve, reject) => {
            // setTimeout(resolve(`{"kor":100, "eng":200}`), 2000);
            resolve(`{"kor":100, "eng":200}`);
            // reject("오마이갓!!");
        });

    // 사고감지. but 조치는 안해. 날 호출하는 함수가 조치.
    // setTimeout(eventHandler, 3000);
    // setTimeout(successHandler, 5000);

}

// drive() 중 사고나면 전화해!
let promise = getList(5);





// 프로미스 : 콜백을 담는 그릇
// 원 함수에서 콜백함수를 분리해냈다

// chaining
promise
    .then(
        (data) => {
            console.log("완주햇다", data);

            // 1. 파싱
            try {
                let json = JSON.parse(data);                
                return json;
            } catch (e) {
                console.log("중첩문 캐치");
            }
            // 2. 압축/키얻기
            // 3. 뽀개기
            // 4. 출력(사용)

        },
        (error) => {
            console.log("사고발생")
        })
    .catch(error=>{
        console.log("잡았다", error)
    })
    // .then(d => {
    //     return {...d, kor:300};
    // })
    .then((json) => {
        console.log(json.kor, json);
    })
    .catch(error=>{
        console.log("잡았다2", error)
    })
