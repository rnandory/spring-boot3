<!-- <script>
    export default {
        setup() {

        },
        data() {

        },
        methods: {

        }
    }
</script> -->

<script setup>
import { onBeforeMount, onBeforeUpdate, onMounted, onUpdated, reactive, ref } from 'vue';
import axios from 'axios';

// 문제 1. 어떤 api? xhr, fetch, axios

// 문제 2. 어느 블록에서 호출? 라이프사이클

const menus = ref([]);
// const model = reactive({
//     totalCount: 0,
//     menus: []
// });
const totalCount = ref(0);
const totalPages = ref(0);
const hasPreviousPage = ref(false);
const hasNextPage = ref(false);
const query = ref({ k: '' });
const pageNumbers = ref([1,2,3,4,5]);

// --- Data functions ------------------------------------------------
const queryString = () => {
    return `?k=${query.value.k}`;
}

// --- Life cycle functions --------------------------
onBeforeMount(() => {
    console.log("before Mount");
    fetchMenus();
})

onMounted(() => {
    console.log("Mounted");
    // fetchMenusWithAxios();
})

onBeforeUpdate(() => {
    console.log("before Update");
})

onUpdated(() => {
    console.log("Updated");
})

// --- fetch functions----------------------------------------------
const fetchMenus = async () => {
    const response = await fetch(`http://localhost:8080/api/v1/admin/menus${queryString()}`);
    // console.log(response);
    const data = await response.json();
    // console.log(result);
    menus.value = data.menus;
    // module.menus = result.menus;    

    totalCount.value = data.totalCount;
    totalPages.value = data.totalPages;
    hasPreviousPage.value = data.hasPreviousPage;
    hasNextPage.value = data.hasNextPage;
}

const fetchMenusWithAxios = async () => {
    const response = await axios.get("http://localhost:8080/api/v1/admin/menus");
    menus.value = response.data.menus;
    
}

// --- callback functions --------------------------
// function addButtonClickHandler() { //순수 static함수의 의미가 약함. 밖의 this공유불가
// }

const searchButtonClickHandler = async (e) => {
    console.log("search", query.value.k);
    fetchMenus();
}

const addButtonClickHandler = (e) => {
    console.log("add");
    // 2. MVC 처리방법: 모델(문서에 바인딩된 객체)를 처리하는 방법
    menus.value.push({ korName: "아샷추" });    

    // 1. DOM 처리방법: 화면(문서)를 직접 처리
    //     let trTemplate = `<tbody>
    //                             <tr>
    //                                 <td>1</td>
    //                             </tr>
    //                             <tr>
    //                                 <td>2</td>
    //                             </tr>
    //                         </tbody>`;
    //     const table = document.querySelector("table");
    //     table.insertAdjacentHTML("beforeend", trTemplate);
    // }
}

const delButtonClickHandler = (e) => {
    console.log("del")
    menus.value.pop();
}
</script>

<template>
    <main>
        <section class="">
            <header class="n-bar">
                <h1 class="n-heading:5">제품관리 / 메뉴관리</h1>
                <div class="ml:3 d:flex">
                    <a href="reg" class="n-icon n-icon:plus n-btn n-btn:rounded n-btn-size:small">추가</a>
                </div>
            </header>

            <section class="n-frame:rounded-shadow">
                <header>
                    <h1><span class="n-icon n-icon:search n-deco">검색</span></h1>
                    <div class="ml:auto">
                        <label class="n-icon n-icon:caret_down cursor:pointer">
                            <span>확장버튼</span>
                            <input class="d:none n-panel-expander" type="checkbox">
                        </label>
                    </div>
                </header>
                <form action="list" method="get" class="n-form n-label-pos:left">
                    <div>
                        <label>
                            <span>한글명</span>
                            <input v-model="query.k" type="text" name="q" th:value="${param.q}">
                        </label>
                    </div>
                    <div class="d:flex flex-direction:row jc:center">
                        <label class="">
                            <input type="checkbox" value="0" class="fl-grow:0">
                            <span class="w:auto">전체</span>
                        </label>
                        <label th:each="c : ${categories}">
                            <input th:if="${param.c} == ${c.id}" type="checkbox" name="c" th:value="${c.id}"
                                class="fl-grow:0" checked>
                            <input th:if="${param.c} != ${c.id}" type="checkbox" name="c" th:value="${c.id}"
                                class="fl-grow:0">
                            <span class="w:auto" th:text="${c.name}">쿠키</span>
                        </label>
                    </div>
                    <div class="d:flex">
                        <button class="n-btn n-btn-color:main" @click.prevent="searchButtonClickHandler">검색</button>
                        <button class="n-btn ml:1">취소</button>
                    </div>
                </form>
            </section>

            <section class="n-frame:rounded-shadow">

                <header>
                    <h1 class="d:none2"><span class="n-icon n-icon:view_list n-deco n-deco-gap:2">메뉴목록</span></h1>
                    <div>
                        <span class="ml:1 n-heading:6"><span>({{ totalCount }})</span></span>
                        <button class="n-btn ml:3" @click="addButtonClickHandler">추가</button>
                        <button class="n-btn ml:3" @click="delButtonClickHandler">삭제</button>
                    </div>
                </header>


                <table class="n-table n-table:expandable">
                    <thead>
                        <tr>
                            <th class="w:1">번호</th>
                            <th class="w:0 md:w:4 overflow:hidden">사진</th>
                            <th>한글명</th>
                            <th class="w:0 md:w:2 n-heading-truncate">공개</th>
                            <th class="w:3">비고</th>
                        </tr>
                    </thead>
                    <tbody v-for="m in menus" th:each="m : ${menus}">
                        <tr class="vertical-align:middle">
                            <td th:text="${m.id}">2</td>
                            <td class="w:0 md:w:4 overflow:hidden"><img class="w:100p h:0 md:h:3 object-fit:cover"
                                    src="/image/product/americano.svg" th:src="@{/image/product/{img}(img=${m.img})}">
                            </td>
                            <td class="text-align:start n-heading-truncate text-indent:4 text-align:cetner">
                                <a href="detail" th:href="@{detail(id=${m.id})}">{{ m.korName }}</a>
                            </td>
                            <td class="w:0 md:w:2 n-heading-truncate">
                                <label>
                                    <span class="d:none">공개</span>
                                    <input type="checkbox" class="n-toggle ml:auto">
                                </label>
                            </td>
                            <td>
                                <span class="d:inline-flex align-items:center">
                                    <label class="n-icon n-icon:caret_down n-icon-size:2 n-btn mr:2">
                                        <input type="checkbox" class="d:none n-row-expander">
                                        <span>상세보기</span>
                                    </label>
                                    <a class="n-icon n-icon:edit_square n-icon-color:base-6" href="detail"
                                        th:href="@{detail(id=${m.id})}">수정</a>
                                    <form action="del" method="post" class="d:flex ai:center">
                                        <input type="hidden" name="id" th:value="${m.id}">
                                        <button class="n-icon n-icon:delete n-icon-color:base-6"
                                            type="submit">삭제</button>
                                    </form>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="5" class="bg-color:base-2">
                                <section class="">
                                    <h1 class="d:none">상세내용</h1>
                                    <dl class="n-list:dash-lined">
                                        <div class="md:d:none">
                                            <dt>공개</dt>
                                            <dd class="ml:1">
                                                <label>
                                                    <span class="d:none">공개</span>
                                                    <input type="checkbox" class="n-toggle n-toggle-size:1 ml:auto">
                                                </label>
                                            </dd>
                                        </div>
                                        <div>
                                            <dt>영문명</dt>
                                            <dd class="ml:1" th:text="${m.engName}">Cafe Latte</dd>
                                        </div>
                                        <div>
                                            <dt>사진</dt>
                                            <dd class="ml:1">
                                                <ul class="n-bar flex-wrap:wrap">
                                                    <li th:each="img : ${m.images}" th:classappend="'active:border'">
                                                        <img class="max-width:5"
                                                            th:src="@{/image/product/{img}(img=${img.src})}"
                                                            src="/image/product/americano.svg">
                                                    </li>
                                                </ul>
                                            </dd>
                                        </div>
                                        <div>
                                            <dt>가격</dt>
                                            <!--/*
참고자료
타임리프 숫자포맷 유틸객체 :  https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf#numbers
*/-->
                                            <dd class="ml:1" th:text="${#numbers.formatInteger(m.price,3,'COMMA')}+'원'">
                                                1,000원</dd>
                                        </div>
                                        <div>
                                            <dt>등록일자</dt>
                                            <!--/*
참고자료
타임리프 날짜포맷 유틸객체 : https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf#dates
자바 날짜포맷 문자들 : https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/text/SimpleDateFormat
*/-->

                                            <dd class="ml:1"
                                                th:text="${#dates.format(m.regDate, 'yyyy-MM-dd a HH:mm')}">2024-12-25
                                                12:00:00</dd>
                                        </div>
                                    </dl>

                                </section>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="mt:4 text-align:center">
                    <ul class="n-bar">
                        <li v-for="p in pageNumbers" :key="p">
                            <a class="n-btn" href="">{{ p }}</a>
                        </li>
                    </ul>
                </div>
            </section>

        </section>
    </main>
</template>