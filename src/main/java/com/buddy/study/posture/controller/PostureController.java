package com.buddy.study.posture.controller;

import com.buddy.study.posture.dto.CreateRequest;
import com.buddy.study.posture.dto.PostureResponse;
import com.buddy.study.posture.service.PostureService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posture")
public class PostureController {
    private final PostureService postureService;
    @Operation(summary = "자세 업데이트")
    @PostMapping
    public ResponseEntity<PostureResponse> createTemperature(@RequestHeader("Authorization") UUID userId, @RequestBody CreateRequest request) {
        return ResponseEntity.ok(postureService.createPosture(userId, request));
    }
    @Operation(summary = "자세 조회")
    @GetMapping
    public ResponseEntity<PostureResponse> getTemperature(@RequestHeader("Authorization") UUID userId) {
        return ResponseEntity.ok(postureService.getPosture(userId));
    }

}
