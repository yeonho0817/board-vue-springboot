import api from '@/modules/axios';

const boardService = {
    async getBoardList(pageSize: Number, pageNumber: Number) {
        return await (await api.get('/board/list', { params : { pageSize: pageSize, pageNumber: pageNumber } })).data;
    },

    async getBoardDetail(boardId: String) {
        console.log(boardId);
        return await (await api.get('/board/detail', { params : { boardId: boardId } })).data;
    }
}

export default boardService;