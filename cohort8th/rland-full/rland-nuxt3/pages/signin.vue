<script setup>
import { decodeCredential, googleTokenLogin } from 'vue3-google-login';

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
            <form>
                <div>
                    <label for="">
                        사용자 아이디:
                        <input type="text">
                    </label>
                </div>
                <div>
                    <label for="">
                        비밀번호:
                        <input type="text">
                    </label>
                </div>
                <div>
                    <input type="submit" value="로그인">
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