package com.buddy.study.common.controller;

import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final CommonService commonService;
    @GetMapping("/duplication")
    public ResponseEntity<MessageResponse> checkName(@RequestParam("name")String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonService.checkUser(name));
    }
}
