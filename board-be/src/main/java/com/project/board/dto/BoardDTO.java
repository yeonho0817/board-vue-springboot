package com.project.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class BoardDTO {

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

}
