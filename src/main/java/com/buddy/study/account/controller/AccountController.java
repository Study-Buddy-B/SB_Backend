package com.buddy.study.account.controller;


import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.common.dto.FailResponse;
import com.buddy.study.common.dto.MessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {
    final private AccountService accountService;
    @PostMapping("")
    public ResponseEntity<MessageResponse> joinUser(@RequestBody JoinRequest joinRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.saveUser(joinRequest));
    }
    @DeleteMapping("")
    public ResponseEntity<MessageResponse> outUser(@RequestHeader("Authorization") UUID uuid){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.outUser(uuid));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> joinUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.loginUser(loginRequest));
    }
}
