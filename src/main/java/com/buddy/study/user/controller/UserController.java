package com.buddy.study.user.controller;

import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.user.dto.TimeRequest;
import com.buddy.study.user.dto.UserResponse;
import com.buddy.study.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @Operation(summary = "홈 화면")
    @GetMapping("")
    public ResponseEntity<UserResponse> loadUser(@RequestHeader("Authorization") UUID userId){
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.loadUser(userId));
    }
    @Operation(summary = "목표 시간 설정")
    @PostMapping("/time")
    public ResponseEntity<MessageResponse> timeUser(@RequestHeader("Authorization") UUID userId, @RequestBody
        TimeRequest timeRequest){
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.setTime(userId, timeRequest));
    }
}
