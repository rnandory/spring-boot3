<script setup>
import { decodeCredential } from 'vue3-google-login';
// import { actions } from '~/gvar/userDetails'

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

</script>

<template>
    <main>
        <GoogleLogin :callback="callback" />
        <section>
            <h1>로그인 페이지</h1>
            <div>
                <a href="">구글 로그인</a>
            </div>
        </section>
    </main>
</template>

<style scoped></style>