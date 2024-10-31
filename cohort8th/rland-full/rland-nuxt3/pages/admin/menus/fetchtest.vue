<script setup>
const config = useRuntimeConfig();
const { data } = useFetch(`admin/menus`, {
    baseURL: config.public.apiBase,
    params: { p: 3 }
});

const menus = ref([]);
const pageNumbers = ref([]);

watchEffect(() => {
    if (data.value) {
        menus.value = data.value.menus;
        pageNumbers.value = data.value.pages;
    }
});

</script>

<template>
    <main>
        <!-- {{ data }} -->
        {{ pageNumbers }}<br>
        {{ menus }}<br>
    </main>
</template>