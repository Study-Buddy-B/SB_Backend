package com.buddy.study.common.exception;

import com.buddy.study.common.dto.FailResponse;
import com.buddy.study.common.dto.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice("com.buddy.study")
public class FailExceptionHandler {
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<FailResponse> conflictHandler(ConflictException e){
        ErrorCode errorCode=e.getErrorCode();
        FailResponse failResponse = FailResponse.of(errorCode);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(failResponse);
    }
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<FailResponse> unauthorizedHandler(UnauthorizedException e){
        ErrorCode errorCode=e.getErrorCode();
        FailResponse failResponse = FailResponse.of(errorCode);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failResponse);
    }
}
