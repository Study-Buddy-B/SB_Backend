package com.buddy.study.group.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum GroupType {
    ENGLISH(0,"영어공부"),
    EMPLOYMENT(1,"취업준비"),
    CODING(2,"모각코"),
    PUBLIC_OFFICIAL(3,"공무원준비"),
    RECRUITMENT_NOTICE(4, "임용고시");
    private Integer code;
    private String message;
    GroupType(Integer code, String message) {
        this.code=code;
        this.message=message;
    }

    public static GroupType valueOfType(Integer code){
        return Arrays.stream(values())
                .filter(value -> value.getCode().equals(code))
                .findAny()
                .orElse(null);
    }

}
