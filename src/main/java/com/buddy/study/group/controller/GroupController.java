package com.buddy.study.group.controller;

import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {
    final private GroupService groupService;
    @PostMapping("")
    public ResponseEntity createGroup(@RequestBody JoinRequest joinRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
