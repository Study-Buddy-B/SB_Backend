package com.buddy.study.common.exception;

import com.buddy.study.common.dto.ErrorCode;
import lombok.Getter;

@Getter
public class UnauthorizedException extends RuntimeException{
    private ErrorCode errorCode;
    public UnauthorizedException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

}
