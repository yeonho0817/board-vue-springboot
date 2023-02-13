package com.project.board.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ResponseData<T> {
    private Status status;
    private String message;
    private T data;

    public ResponseData(Status status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResponseData(Status status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

}
