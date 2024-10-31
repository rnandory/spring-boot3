import { defineNuxtPlugin } from "#app";
import vue3GoogleLogin from "vue3-google-login";

export default defineNuxtPlugin((nuxtApp) => {
  nuxtApp.vueApp.use(vue3GoogleLogin, {
    clientId:
      "251205663314-6d0bd8liht3otcch2v536r3spcl9aaep.apps.googleusercontent.com",
  });
});
