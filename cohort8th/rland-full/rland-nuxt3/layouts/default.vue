<script setup>
import RlandFooter from '~/components/RlandFooter.vue';
import RlandHeader from '~/components/RlandHeader.vue';    
</script>

<template> 
    <RlandHeader/>
    <slot />
    <RlandFooter/>
</template>