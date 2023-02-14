package com.project.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class BoardDTO {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardListData {
        private List<BoardData> boardDatas;
        private Long totalCount;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardData {
        private Long boardId;
        private String title;
        private Long writeMemberId;
        private String writeMemberName;
        private String registerDate;
        private Integer views;

        private Long commentCount;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BoardDetailData {
        private Long boardId;
        private String title;
        private Long writeMemberId;
        private String writeMemberName;
        private String content;
        private String registerDate;
        private Integer views;

        private Long commentCount;
    }



}
