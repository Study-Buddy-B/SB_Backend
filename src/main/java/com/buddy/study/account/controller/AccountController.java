package com.buddy.study.account.controller;


import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.common.dto.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
public class AccountController {
    final private AccountService accountService;
    @PostMapping("")
    public ResponseEntity<CommonResponse> joinUser(@RequestBody JoinRequest joinRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.saveUser(joinRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity outUser(@PathVariable(name="id") Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.outUser(id));
    }
    @GetMapping("/duplication")
    public ResponseEntity<CommonResponse> dupUser(@RequestParam("email") String email){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.checkUser(email));
    }
    @PostMapping("/login")
    public ResponseEntity<CommonResponse> joinUser(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.loginUser(loginRequest));
    }
}
