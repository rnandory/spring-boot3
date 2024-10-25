<script setup>
import { useRoute, useRouter } from 'vue-router';


const route = useRoute();
const router = useRouter();

</script>
<template>
    <main class="">

        <section class="">
            <header class="n-bar">
                <h1 class="n-heading:5">제품관리 / 메뉴관리</h1>
                <div class="ml:3 d:flex ai:center">
                    <RouterLink to="../menus" class="n-icon n-icon:arrow_left n-btn n-btn:rounded n-btn-size:small">뒤로
                    </RouterLink>
                </div>
            </header>

            <section class="n-frame:rounded-shadow">
                <header>
                    <h1><span class="n-icon n-icon:post_add n-deco">메뉴등록</span></h1>
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
                        <button class="n-btn n-btn-color:main">등록</button>
                        <RouterLink :to="`${route.path}/edit`" class="n-btn n-btn-color:main">등록 후 이미지 추가</RouterLink>
                        <RouterLink :to="`${route.path}`" class="n-btn">취소</RouterLink>
                    </div>
                </form>
            </section>

        </section>
    </main>
</template>