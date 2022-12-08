package com.buddy.study.group.controller;

import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.common.dto.MessageResponse;
import com.buddy.study.group.dto.CreateResponse;
import com.buddy.study.group.dto.DetailResponse;
import com.buddy.study.group.dto.DetailsResponse;
import com.buddy.study.group.dto.GroupRequest;
import com.buddy.study.group.dto.GroupResponse;
import com.buddy.study.group.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "그룹 생성")
    @PostMapping("")
    public ResponseEntity<CreateResponse> createGroup(@RequestHeader("Authorization") UUID uid,
                                                      @RequestBody GroupRequest groupRequest){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.createGroup(uid,groupRequest));
    }
    @Operation(summary = "그룹 가입")
    @GetMapping("/join")
    public ResponseEntity<MessageResponse> joinGroup(@RequestHeader("Authorization") UUID uid,
                                                     @RequestParam("groupId")Long gid){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.joinGroup(uid,gid));
    }
    @Operation(summary = "모든 그룹 조회")
    @GetMapping("")
    public ResponseEntity<List<GroupResponse>> loadAllGroup(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(groupService.loadGroup(null));
    }
    @Operation(summary = "그룹 상세 보기")
    @GetMapping("/{gid}")
    public ResponseEntity<DetailsResponse> loadGroup(@PathVariable Long gid){
        return ResponseEntity.status(HttpStatus.OK)
            .body(groupService.detailGroup(gid));
    }
    @Operation(summary = "속한 그룹 조회")
    @GetMapping("/belong")
    public ResponseEntity<List<GroupResponse>> loadMyGroup(@RequestHeader("Authorization") UUID uid){
        return ResponseEntity.status(HttpStatus.OK)
            .body(groupService.loadGroup(uid));
    }
}
