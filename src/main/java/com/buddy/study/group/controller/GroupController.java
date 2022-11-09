package com.buddy.study.group.controller;

import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.group.dto.CreateResponse;
import com.buddy.study.group.dto.GroupRequest;
import com.buddy.study.group.dto.GroupResponse;
import com.buddy.study.group.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/group")
public class GroupController {
    final private GroupService groupService;
    @PostMapping("")
    public ResponseEntity<CreateResponse> createGroup(@RequestHeader("Authorization") UUID uid,
                                                      @RequestBody GroupRequest groupRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.createGroup(uid,groupRequest));
    }
    @GetMapping("join")
    public ResponseEntity<MessageResponse> joinGroup(@RequestHeader("Authorization") UUID uid,
                                                     @RequestParam("groupId")Long gid){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.joinGroup(uid,gid));
    }
    @GetMapping("")
    public ResponseEntity<List<GroupResponse>> loadAllGroup(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.loadGroup());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Void> loadAllGroup(@PathVariable Long gid){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long gid){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
