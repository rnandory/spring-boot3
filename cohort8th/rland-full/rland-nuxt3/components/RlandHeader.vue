<script setup>
// import { actions } from '~/gvar/userDetails'
const userDetails = useUserDetails();
</script>
<template>
    <header class="header">
        <h1>
            <RouterLink to="/">Rland</RouterLink>
            <NuxtLink to="/admin">관리자</NuxtLink>
            <NuxtLink v-if="userDetails.isAnonymous()" to="/signin">로그인</NuxtLink>
            <NuxtLink v-else to="/signout">로그아웃</NuxtLink>
        </h1>
        <div class="top-mobile-menu">
            <a class="n-icon n-icon:list n-icon-color:base-1" href="top-menu=1">숨김버튼</a>
        </div>
        <div class="top-menu">
            <nav>
                <h1 class="d:none">상단메뉴</h1>
                <ul>
                    <li>
                        <RouterLink class="n-icon n-icon:home n-icon-color:base-1" to="/">홈</RouterLink>
                    </li>
                    <li>
                        <RouterLink class="n-icon n-icon:dashboard n-icon-color:base-1" to="/admin/index">대시보드
                        </RouterLink>
                    </li>
                    <li>
                        <RouterLink class="n-icon n-icon:user n-icon-color:base-1" to="/">로그인</RouterLink>
                    </li>
                </ul>
            </nav>
            <section>
                <h1 class="d:none">로그아웃 폼</h1>
                <form>
                    <input type="hidden">
                    <button class="n-icon n-icon:sign_out n-icon-color:base-1">로그아웃</button>
                </form>
            </section>
        </div>
    </header>
</template>

<style>
@import url("/public/css/header.css");
</style>