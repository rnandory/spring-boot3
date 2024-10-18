// 라이브러리 or api
function getList(page) {

    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(`{"kor":100, "eng":200}`);
        }, 2000);

        // reject("오마이갓!!");
    });
}

// let exam = getList(5);
// console.log(exam
//     .then(data => {
//         console.log(data);
//     }));
// console.log("다음 라인");



// IIFE
(async () => {
    let exam = await getList(5);
    console.log(exam
        .then(data => {
            console.log(data);
        }));
    console.log("다음 라인");
})();