const category = document.getElementById("category");
const ul = category.querySelector("ul");

const menuList = document.querySelector(".menu-list");

ul.onclick = function (e) {
    e.preventDefault();

    if (!e.target.classList.contains("btn"))
        return;

    let id = e.target.dataset.id;

    let request = new XMLHttpRequest();
    request.open("GET", `/api/menus?c=${id}`, false);
    request.send(null);

    console.log(request.responseText);
    let menus = JSON.parse(request.responseText);
    menuList.innerHTML = "";

    menus.forEach(menu => {
        let template = `
                <section class="menu">
                <div>
                    <a href="detail.html">
                        <img
                                src="/image/product/"
                                alt="에스프레소">
                    </a>
                </div>
                <h1>${menu.korName}</h1>
                <h2>${menu.engName}</h2>
                <div>${menu.price}원</div>
                <div>
                    <a href="" class="icon icon-heart">좋아요</a>
                    <span>0</span>
                </div>
                <div>
                    <a href="" class="icon icon-plus icon-lg">추가</a>
                    <a href="" class="icon icon-cart icon-lg">장바구니</a>
                </div>
            </section>`;

        // menuList.innerHTML += template;
        menuList.insertAdjacentHTML("beforeend", template);
    });

}

// const li2 = category.querySelector("li:nth-child(2)");
// li2.onclick = function (e) {
//     console.log("li");
// }
//
// const a2 = category.querySelector("li:nth-child(2)>a");
// a2.onclick = function (e) {
//     console.log(e.target);
//     e.stopPropagation();
//     e.preventDefault();
// }

// const img1 = document.getElementById("img1");
//
// const h1 = document.getElementById("h1");
// h1.onclick = function () {
//     img1.src = "https://cdn.crowdpic.net/detail-thumb/thumb_d_2F583E5543F7E19139C6FCFFBF9607A6.jpg";
//     alert("hehe");
// }
