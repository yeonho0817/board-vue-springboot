package com.project.board.dto.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum Status {
    SUCCESS_READ_BOARD_LIST(200, HttpStatus.OK, "게시판 목록을 성공적으로 조회했습니다."),
    ;

    Status(int code, HttpStatus httpStatus, String description) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.description = description;
    }

    private int code;
    private HttpStatus httpStatus;
    private String description;
}
