package com.buddy.study.common.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {
    DUPLICATE_NAME("1000","닉네임이 중복되었습니다."),
    DUPLICATE_EMAIL("1001","이메일이 중복되었습니다."),
    INVALID_EMAIL("2000","가입되지 않은 이메일입니다."),
    INVALID_PASSWORD("2001","비밀번호가 틀렸습니다."),
    WITHDRAW_EMAIL("2002","이미 탈퇴 처리된 이메일입니다.");
    private String code;
    private String message;
    ErrorCode(String code, String message) {
        this.code=code;
        this.message=message;
    }
}
