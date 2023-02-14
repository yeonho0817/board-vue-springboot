<template lang="">
    <div class="board-list-wrapper">
        <q-table
        class="my-sticky-header-table"
        :columns="columns"
        :rows="boardDatas"
        row-key="boardId"
        :no-data-label="'데이터가 없습니다.'"
        hide-pagination
        >
            <template v-slot:body="props">
                <q-tr :props="props" @click="getBoardDetail(props.row.boardId)">
                    <q-td key="boardId" :props="props">
                        {{ props.row.boardId }}
                    </q-td>
                    <q-td key="title" :props="props">
                        {{ props.row.title }} <span class="comment-count-wrapper">[{{ props.row.commentCount }}]</span>
                    </q-td>
                    <q-td key="writeMemberId" :props="props" hidden>
                        {{ props.row.writeMemberId }}
                    </q-td>
                    <q-td key="writeMemberName" :props="props">
                        {{ props.row.writeMemberName }}
                    </q-td>
                    <q-td key="registerDate" :props="props">
                        {{ props.row.registerDate }}
                    </q-td>
                    <q-td key="views" :props="props">
                        {{ props.row.views }}
                    </q-td>
                </q-tr>
            </template>

        </q-table>

        <div class="pagination-wrapper">
            <div class="pagination-content">
                <q-pagination
                    v-model="pagination.page"
                    :max=maxPages
                    :max-pages="8"
                    direction-links
                    push
                    color="teal"
                    active-design="push"
                    active-color="orange"
                    @click="onPageChange()"
                />
            </div>
            <div class="page-count-wrapper">
                <q-select v-model="pagination.rowsPerPage" :options="pagination.option" label="갯수" @update:model-value="onPageChange()" />
            </div>
        </div>
    </div>
</template>
<script setup lang="ts">

import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';

import BoardService from '@/service/BoardService'

const router = useRouter();

const columns = [
    { name: 'boardId', align: 'center', label: '번호', field: 'boardId', style:'width:100px; cursor: pointer;' },
    { name: 'title', align: 'center', label: '제목', field: 'title', style:'width:400px; cursor: pointer;' },
    { name: 'writeMemberId', align: 'center', label: '작성자 ID', field: 'writeMemberId', headerClasses:'hidden', classes:'hidden' },
    { name: 'writeMemberName', align: 'center', label: '작성자', field: 'writeMemberName', style:'width:150px; cursor: pointer;' },
    { name: 'registerDate', align: 'center', label: '등록일', field: 'registerDate', style:'width:150px; cursor: pointer;' },
    { name: 'views', align: 'center', label: '조회수', field: 'views', style:'width:100px; cursor: pointer;' },
];

const pagination = ref({
    page: 1,
	rowsPerPage: 10,
	option: [10, 20, 50],
});

const maxPages = ref(0);

const boardDatas = ref( [{
    boardId: '',
    title: '',
    writeMemberId: '',
    writeMemberName: '',
    registerDate: '',
    views: 0,
    commentCount: 0,
}]);

let boardListData = ref({
    boardDatas: boardDatas,
    totalCount: 0,
});

const getBoardList = async () => {
    const response = await BoardService.getBoardList(pagination.value.rowsPerPage, pagination.value.page - 1);

    boardListData.value = response.data;
    boardDatas.value = response.data.boardDatas;
    
    console.log(boardListData.value);

    maxPages.value = Math.ceil(boardListData.value.totalCount / pagination.value.rowsPerPage);
}

const onPageChange = () => {
    getBoardList();
}

const getBoardDetail = (boardId: Number) => {
    router.push({name: 'Board Detail', query: { boardId: boardId.toString() }})
}

onMounted(() => {
    getBoardList();
})

</script>
<style lang="scss">

.board-list-wrapper {
    padding-top: 80px;
    text-align: center;
    margin: auto;
    width: 70%;
}

.comment-count-wrapper {
    padding-left: 10px;
    color: red;
}

.my-sticky-header-table{
  /* height or max-height is important */
    // height: 310px;

    .q-table__top,
    .q-table__bottom,
    thead tr:first-child th {
    /* bg color is important for th; just specify one */
        background-color: #c1f4cd;
        font-weight: 700;
        font-size: 1rem;
    }
    thead tr th {
        position: sticky;
        z-index: 1;
    }
    thead tr:first-child th{
        top: 0;
    }
  /* this is when the loading indicator appears */
    &.q-table--loading thead tr:last-child th{
    /* height of all previous header rows */
        top: 48px;
    }
}

</style>