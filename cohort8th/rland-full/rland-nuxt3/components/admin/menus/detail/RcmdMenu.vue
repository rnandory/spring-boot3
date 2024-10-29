<script setup>

const menus = ref([
    // { "id": 1798, "korName": "올드올드", "engName": "oldmericano", "price": 3000, "regDate": "2024-10-27T12:55:17Z", "categoryId": null, "regMemberId": null, "images": [] }, 
    // { "id": 1797, "korName": "올드올드", "engName": "oldmericano", "price": 3000, "regDate": "2024-10-27T12:55:11Z", "categoryId": null, "regMemberId": null, "images": [] }, 
    { "id": 1795, "korName": "올드올드메리카노", "engName": "oldmericano", "price": 3000, "regDate": "2024-10-27 12:53:56", "categoryId": null, "regMemberId": null, "images": [] },
    // { "id": 1794, "korName": "뉴네오1111", "engName": "newneo", "price": 222000, "regDate": "2024-10-24 11:07:58Z", "categoryId": null, "regMemberId": null, "images": [] }, 
    // { "id": 1793, "korName": "뉴네오1111", "engName": "newneo", "price": 222000, "regDate": "2024-10-24 09:41:19Z", "categoryId": null, "regMemberId": null, "images": [] }, 
    { "id": 1792, "korName": "aaaaa", "engName": null, "price": 2000, "regDate": "2024-10-22 12:16:52", "categoryId": null, "regMemberId": null, "images": [] }]);

// 추천메뉴 추가
const addHandler = (addMenus) => {
    // console.log("add Handler", addMenus);

    // addMenus를 menus에 추가
    // menus.value = menus.value.concat(addMenus);
    menus.value.push(...addMenus);


};

// 추천메뉴 삭제
const deleteHandler = (id) => {
    console.log("delete Handler");

    menus.value = menus.value.filter(m => m.id != id);

    // 삭제한 메뉴는 다시 추천메뉴 추가목록에 추가
};

const isPanelShow = ref(false);
</script>

<template>
    <section class="n-frame:rounded-shadow n-panel:card-grid">
        <header>
            <h1><span class="n-icon n-icon:recommend n-deco">추천목록</span></h1>
            <div class="ml:3 d:flex ai:center">
                <a @click.prevent="isPanelShow = true" href="list.html"
                    class="n-icon n-icon:plus n-btn n-btn:rounded n-btn-size:small">추천메뉴서치패널 show </a>
            </div>
        </header>

        <!-- 추천메뉴검색패널 -->
        <Transition name="slide">
            <AdminMenusDetailRcmdMenuSearchPanel :show="isPanelShow" @add="addHandler" @close="isPanelShow = false" />
        </Transition>

        <div>
            <section v-for="m in menus">
                <header>
                    <h1 class="d:none">{{ m.korName }}</h1>
                    <form method="post" class="mb:5 n-icon n-icon:remove_selection n-deco">
                        <input type="hidden" value="1">
                        <button @click.prevent="deleteHandler(m.id)">삭제</button>
                    </form>
                </header>
                <div><img src="/image/product/latte.svg"></div>
                <dl class="n-list:dash-lined">
                    <div>
                        <dt>한글명</dt>
                        <dd>{{ m.korName }}</dd>
                    </div>
                    <div>
                        <dt>등록일자</dt>
                        <dd>{{ m.regDate }}</dd>
                    </div>
                </dl>
            </section>
        </div>
    </section>
</template>

<style>
/* Move in and out animations */
.slide-enter-active, .slide-leave-active {
  transition: transform 1s ease;
}
.slide-enter-from {
  transform: translateY(-437px); /* 위에서 아래로 들어오는 애니메이션 */
  
}
.slide-leave-to {
  transform: translateY(-437px); /* 위로 나가는 애니메이션 */
  
}
</style>