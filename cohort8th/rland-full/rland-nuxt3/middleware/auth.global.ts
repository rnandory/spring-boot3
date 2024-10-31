import userDetails, { actions as auth } from '~/gvar/userDetails';

export default defineNuxtRouteMiddleware((to, from) => {
    console.log(to);

    // 1. 너 누구야? 인증정보
        // 1-1. 없음 -> signin페이지로
        // 1-2. 일단 2단계로 통과

    // 2. /admin**이 목적지라면 관리자인지 확인
        // 2-1. 예 -> 통과
        // 2-2. 아니오 -> 403에러

        const userDetails = useUserDetails();
    
    if (to.path.startsWith("/admin")) {
        if(userDetails.isAnonymous()) // 인증정보를 가지고 있지 않다면?
            return navigateTo(`/signin?returnURL=${to.fullPath}`);

        // if ((userDetails.roles as String[]).includes('admin'))
        //     return navigateTo("/admin");
    }
})