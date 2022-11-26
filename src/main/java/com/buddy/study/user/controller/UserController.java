package com.buddy.study.user.controller;

import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.user.dto.TimeRequest;
import com.buddy.study.user.dto.UserResponse;
import com.buddy.study.user.service.UserService;
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
    @GetMapping("")
    public ResponseEntity<UserResponse> loadUser(@RequestHeader("Authorization") UUID userId){
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.loadUser(userId));
    }
    @PostMapping("/time")
    public ResponseEntity<MessageResponse> timeUser(@RequestHeader("Authorization") UUID userId, @RequestBody
        TimeRequest timeRequest){
        return ResponseEntity.status(HttpStatus.OK)
            .body(userService.setTime(userId, timeRequest));
    }
}
