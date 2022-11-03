package com.buddy.study.common.exception;

import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice("com.buddy.study")
public class FailExceptionHandler {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<CommonResponse> conflictHandler(ConflictException e){
        ErrorCode errorCode=e.getErrorCode();
        CommonResponse commonResponse=CommonResponse.of(errorCode,null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(commonResponse);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<CommonResponse> unauthorizedHandler(UnauthorizedException e){
        ErrorCode errorCode=e.getErrorCode();
        CommonResponse commonResponse=CommonResponse.of(errorCode,null);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(commonResponse);
    }
}
