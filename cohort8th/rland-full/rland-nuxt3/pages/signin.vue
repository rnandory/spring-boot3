<script setup>
import { decodeCredential, googleTokenLogin } from 'vue3-google-login';

// === reactive variables ===============================================================================
const username = ref("");
const password = ref("");


// === callback functions ===============================================================================
const localLoginHandler = async () => {
    console.log('localLoginHandler called');
    // 서버로 인증정보를 제공하면서 인증 요청 후 리소스 서버에 access_token을 가지고 재요청

    /*
    이 방식으로 하면 SSR에서 fetch가 이루어짐 + 매번 config으로 공통url얻어오고 쿼리스트링 url작성 
    => composable로 useDataFetch
    const config = useRuntimeConfig();    
    useFetch(`${config.public.apiBase}auth/login`);
    */

    let test = await useDataFetch("auth/signin", {
        method: "POST",
        header: {
            "Content-type": "application/json"
        },
        body: {
            username: username.value,
            password: password.value
        }
    });
    console.log(test);

    // 우리는 인증서버 + 리소스서버이기 때문에 id_token을 바로 받아서 처리
    // 앞에서 받은 사용자정보를 이용해서 상태저장
    // 사용자에 따른 페이지로 이동
}

const callback = (response) => {
    // This callback will be triggered when the user selects or login to
    // his Google account from the popup
    // console.log("Handle the response", response) // jwt, saml
    let user = decodeCredential(response.credential);
    // console.log(user);

    let userDetails = useUserDetails();

    userDetails.login({
        id: 1,
        userName: user.name,
        email: user.email,
        roles: ['member', 'admin']
    });

    const returnURL = useRoute().query.returnURL || "/";

    return navigateTo(returnURL);
}

const googleLoginHandler = async () => {
    let token;
    {
        // promise를 반환하는 비동기 googleTokenLogin()에서 값을 받아오는 법
        // 1. await
        // 2. .then
        let response = await googleTokenLogin();
        console.log(response);
        token = response.access_token;
    }

    {
        let response = await fetch(`https://www.googleapis.com/oauth2/v3/userinfo?access_token=${token}`);
        let userInfo = await response.json(); // id token
        console.log(userInfo);
    }
}

</script>

<template>
    <main>
        <section>
            <h1>로그인 페이지</h1>
            <form @submit.prevent="localLoginHandler">
                <div>
                    <label for="">
                        사용자 아이디:
                        <input type="text" v-model="username" required placeholder="아이디를 입력하세요">
                    </label>
                </div>
                <div>
                    <label for="">
                        비밀번호:
                        <input type="text" v-model="password" required placeholder="비밀번호를 입력하세요">
                    </label>
                </div>
                <div>
                    <input class="n-btn n-btn-color:sub" type="submit" value="로그인">
                </div>
                <div>
                    <a @click.prevent="googleLoginHandler" class="n-btn n-btn-color:main" href="">구글 로그인</a>
                </div>
                <div>
                    <GoogleLogin :callback="callback" />
                </div>
            </form>
        </section>
    </main>
</template>

<style scoped></style>