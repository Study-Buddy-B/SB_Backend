package com.buddy.study.common.dto;

import lombok.Data;

@Data
public class FailResponse {
    private String code;
    private String message;
    public FailResponse(ErrorCode code) {
        this.message = code.getMessage();
        this.code = code.getCode();
    }

    public static FailResponse of(ErrorCode code) {
        return new FailResponse(code);
    }
}
