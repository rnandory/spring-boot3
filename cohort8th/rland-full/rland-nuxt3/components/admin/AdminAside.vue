<template>
    <aside class="">
        <header class="n-aside-menu">
            <h1 class="d:none">
                <RouterLink to="">관리자 메뉴</RouterLink>
            </h1>
            <ul>
                <li class="">
                    <RouterLink class="n-icon n-icon:dashboard n-deco n-deco-pos:top lg:n-deco-pos:left" to="/admin">
                        대시보드</RouterLink>
                </li>
            </ul>
        </header>
        <nav class="n-aside-menu">
            <h1>재품관리</h1>
            <ul>
                <li class="active">
                    <RouterLink class="n-icon n-icon:local_cafe n-deco n-deco-pos:top lg:n-deco-pos:left"
                        to="/admin/menus">메뉴관리</RouterLink>
                </li>
                <li>
                    <RouterLink class="n-icon n-icon:household_supplies n-deco n-deco-pos:top lg:n-deco-pos:left"
                        to="/admin/supplies/list">비품관리</RouterLink>
                </li>
            </ul>
        </nav>
        <nav class="n-aside-menu">
            <h1>고객관리</h1>
            <ul>
                <li>
                    <RouterLink class="n-icon n-icon:bell n-deco n-deco-pos:top lg:n-deco-pos:left" to="/admin/notices">
                        공지관리</RouterLink>
                </li>
                <li>
                    <RouterLink class="n-icon n-icon:group n-deco n-deco-pos:top lg:n-deco-pos:left"
                        to="/admin/members">회원관리</RouterLink>
                </li>
            </ul>
        </nav>
        <nav class="n-aside-menu">
            <h1>통계관리</h1>
            <ul>
                <li>
                    <RouterLink class="n-icon n-icon:cardio_load n-deco n-deco-pos:top lg:n-deco-pos:left" to="">좋아요
                    </RouterLink>
                </li>
                <li>
                    <RouterLink class="n-icon n-icon:bookmarks n-deco n-deco-pos:top lg:n-deco-pos:left" to="">짐목록
                    </RouterLink>
                </li>
            </ul>
        </nav>

    </aside>
</template>