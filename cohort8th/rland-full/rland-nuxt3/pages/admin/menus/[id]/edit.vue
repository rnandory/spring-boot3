<script setup>
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
console.log(route.path);
</script>

<template>
    <main class="">

        <section class="">
            <header class="n-bar">
                <h1 class="n-heading:5">제품관리 / 메뉴관리</h1>
                <div class="ml:3 d:flex ai:center">
                    <RouterLink :to="`${route.path.replace(/\/edit$/, '')}`"
                        class="n-icon n-icon:arrow_left n-btn n-btn:rounded n-btn-size:small">뒤로
                    </RouterLink>
                </div>
            </header>

            <section class="n-frame:rounded-shadow">
                <header>
                    <h1><span class="n-icon n-icon:edit_square n-deco">메뉴수정</span></h1>
                </header>
                <form class="n-form n-label-pos:left">
                    <div>
                        <label>
                            <span>한글명</span>
                            <input type="text">
                        </label>
                    </div>
                    <div>
                        <label>
                            <span>영문명</span>
                            <input type="text">
                        </label>
                    </div>
                    <div>
                        <label>
                            <span>가격</span>
                            <input type="text">
                        </label>
                    </div>
                    <div>
                        <label>
                            <span>설명</span>
                            <textarea></textarea>
                        </label>
                    </div>
                    <div class="fl-dir:row jc:end">
                        <button class="n-btn n-btn-color:main">저장</button>
                        <a href="detail.html" class="n-btn">취소</a>
                    </div>
                </form>
            </section>

            <!-- -- 이미지 추가 프레임-------------------- -->
            <section class="n-frame:rounded-shadow">
                <header>
                    <h1>이미지 추가</h1>
                    <div class="n-message:error-7 ml:3">
                        - 사진이 서버에 저장되었습니다.
                    </div>
                    <div class="h:4 w:100p mt:3 bg-color:main-1a position:relative">
                        <div class="w:8p bg-color:main-1 position:absolute text-align:end color:base-1">
                            88%
                        </div>
                        <label class="d:flex h:100p ai:center jc:center">
                            <span class="n-icon n-icon:plus">사진선택</span>
                            <input class="d:none" type="file">
                        </label>
                    </div>
                </header>
                <ul class="n-bar">
                    <li class="w:3 position:relative">
                        <form class="position:absolute right:0 top:0">
                            <input type="hidden" value="1">
                            <button class="n-icon n-icon:delete n-icon-color:main-1 n-btn:rounded">삭제</button>
                        </form>
                        <img class="h:3 w:100p obj-fit:cover" src="/image/product/latte.svg">
                    </li>
                    <li class="w:3 position:relative">
                        <form class="position:absolute right:0 top:0">
                            <input type="hidden" value="1">
                            <button class="n-icon n-icon:delete n-icon-color:main-1 n-btn:rounded">삭제</button>
                        </form>
                        <img class="h:3 w:100p obj-fit:cover" src="/image/product/latte.svg">
                    </li>
                    <li class="w:3 position:relative">
                        <form class="position:absolute right:0 top:0">
                            <input type="hidden" value="1">
                            <button class="n-icon n-icon:delete n-icon-color:main-1 n-btn:rounded">삭제</button>
                        </form>
                        <img class="h:3 w:100p obj-fit:cover" src="/image/product/latte.svg">
                    </li>
                </ul>
            </section>
            <!-- --/ 이미지 추가 프레임-------------------- -->

        </section>
    </main>
</template>