package com.buddy.study.common.dto;

import lombok.Data;

@Data
public class CommonResponse {
    private String code;
    private String message;
    private Object result;
    public CommonResponse() {
        this.code = "0000";
    }
    public CommonResponse(ErrorCode code, Object result) {
        this.message = code.getMessage();
        this.code = code.getCode();
        this.result = result;
    }
    public CommonResponse success(String message, Object result){
        this.message=message;
        this.result=result;
        return this;
    }
    public static CommonResponse of(ErrorCode code, Object result) {
        return new CommonResponse(code, result);
    }
}
