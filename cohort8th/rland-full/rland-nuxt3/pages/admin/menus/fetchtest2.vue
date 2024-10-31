<script setup>
const config = useRuntimeConfig();
const { data } = useFetch(`admin/menus?p=2`, { baseURL: config.public.apiBase });

const menus = ref([]);
const pageNumbers = ref([]);

console.log("data.value: ", data.value);

// watchEffect(() => {
if (data.value) {
    console.log("if ..")
    menus.value = data.value.menus;
    pageNumbers.value = data.value.pages;
}
// });


</script>

<template>
    <main>
        {{ pageNumbers }}<br>
        {{ menus }}<br>
    </main>
</template>