<script setup>
import { useRoute } from 'vue-router';

const emit = defineEmits(['pageChange']);
const props = defineProps({
    href: {
        type: String,
        default: "./"
    },
    pageNumbers: {
        type: Array,
        default: []
    },
    startNum: {
        type: Number,
        default: 1
    },
    totalPages: {
        type: Number,
        default: 0
    }
});
</script>

<template>
    <div class="mt:4 text-align:center">
        <ul class="n-bar">
            <li>
                <RouterLink @click="emit('pageChange', startNum - 1)" class="n-btn"
                    :to="`${href}?page=${startNum - 1 < 1 ? 1 : startNum - 1}`">이전</RouterLink>
            </li>
            <li v-for="p in pageNumbers" :key="p">
                <RouterLink @click="emit('pageChange', p)" class="n-btn"
                    :class="{ active: p == (useRoute().query.page || 1) }" :to="`${href}?page=${p}`">{{ p }}
                </RouterLink>
            </li>
            <li>
                <RouterLink @click="emit('pageChange', startNum + 5)" class="n-btn"
                    :to="`${href}?page=${startNum + 5 > totalPages ? totalPages : startNum + 5}`">다음
                </RouterLink>
            </li>
        </ul>
    </div>
</template>