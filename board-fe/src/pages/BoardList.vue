<template lang="">
    <div class="board-list-wrapper">
        <q-table
        class="my-sticky-column-table"
        hide-pagination
        :columns="columns"
        :rows="rows"
        row-key="name"
        >

        </q-table>

        <div class="pagination-wrapper">
            <div class="pagination-content">
                <q-pagination
                    v-model="pagination.page"
                    max="5"
                    direction-links
                    push
                    color="teal"
                    active-design="push"
                    active-color="orange"
                    @click="onPageChange"
                />
            </div>
            <div class="page-count-wrapper">
                <q-select v-model="perPage" :options="pagination.option" label="갯수" />
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">

import { ref } from 'vue';

const columns = [
    { name: 'id', align: 'center', label: '번호', field: 'id', style:'width:100px' },
    { name: 'title', align: 'center', label: '제목', field: 'title', style:'width:400px' },
    { name: 'writer', align: 'center', label: '작성자', field: 'writer', style:'width:150px' },
    { name: 'registerDate', align: 'center', label: '등록일', field: 'registerDate', style:'width:150px' },
    { name: 'views', align: 'center', label: '조회수', field: 'views', style:'width:100px' },
];

const rows =[
    { id: 1, title:"hi", writer:'hi', registerDate:'2023-02-13', views:'150'}
]

const perPage = ref(10);
// const maxPage = ref(0);

const pagination = ref({
    page: 1,
	rowsPerPage: 10,
	option: [10, 20, 50],
});

const onPageChange = () => {
    console.log(pagination.value);
}

</script>
<style lang="scss">

.board-list-wrapper {
    padding-top: 80px;
    text-align: center;
    margin: auto;
    width: 70%;
}



</style>