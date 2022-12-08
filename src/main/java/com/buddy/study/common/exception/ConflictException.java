package com.buddy.study.common.exception;

import com.buddy.study.common.dto.ErrorCode;
import lombok.Getter;

@Getter
public class ConflictException extends RuntimeException{
    private ErrorCode errorCode;
    public ConflictException(ErrorCode errorCode){
        this.errorCode = errorCode;
    }

}
