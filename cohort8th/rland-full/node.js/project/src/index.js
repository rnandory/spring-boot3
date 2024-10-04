
window.addEventListener("load", function() {
    let result = add(3,5);
    let template = `<div>result: ${result}</div>`;
    document.body.insertAdjacentHTML("beforeend", template);

})