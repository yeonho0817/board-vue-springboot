<template lang="">
    <div>
        {{ boardId }}
    </div>
</template>
<script setup lang="ts">

import { onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import BoardService from '@/service/BoardService';

const router = useRouter();

const boardId = computed(() => router.currentRoute.value.query.boardId);


const getBoardDetail = async () => {
    console.log(boardId.value);
    const response = await BoardService.getBoardDetail(boardId.value as String);

    console.log(response.data);
};


onMounted(() => {
    getBoardDetail();
});

</script>
<style lang="scss">
    
</style>