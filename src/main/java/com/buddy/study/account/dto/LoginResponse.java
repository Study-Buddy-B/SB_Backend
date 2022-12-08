package com.buddy.study.account.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class LoginResponse {
    private UUID uuid;
    public LoginResponse(UUID uuid){this.uuid=uuid;}
}
