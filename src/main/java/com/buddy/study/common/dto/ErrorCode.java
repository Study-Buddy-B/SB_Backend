package com.buddy.study.common.dto;

import lombok.Getter;

@Getter
public enum ErrorCode {
    //Conflict : 409
    DUPLICATE_NAME("C000","닉네임이 중복되었습니다."),
    DUPLICATE_EMAIL("C001","이메일이 중복되었습니다."),
    MAXIMUM_GROUP("C002","현재 최대인원으로 가입할 수 없습니다."),
    DUPLICATE_GROUP("C003", "이미 가입한 그룹입니다."),
    INVALIDATE_DATE("C004", "날짜 형식이 요구되는 형식과 맞지 않습니다."),
    INVALIDATE_TIME("C005", "목표시간 범위는 1 이상 24 이하 입니다."),

    //Unauthorized : 401
    INVALID_EMAIL("U000","가입되지 않은 이메일입니다."),
    INVALID_PASSWORD("U001","비밀번호가 틀렸습니다."),
    WITHDRAW_EMAIL("U002","이미 탈퇴 처리된 이메일입니다.");
    private String code;
    private String message;
    ErrorCode(String code, String message) {
        this.code=code;
        this.message=message;
    }
}
