package com.buddy.study.notice.controller;

import com.buddy.study.notice.dto.CreateRequest;
import com.buddy.study.notice.dto.NoticeResponse;
import com.buddy.study.notice.service.NoticeService;
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
@RequestMapping("/api/v1/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<NoticeResponse> createNotice(@RequestHeader("Authorization") UUID userId, @RequestBody CreateRequest request) {
        return ResponseEntity.ok(noticeService.createNotice(userId, request));
    }

    @GetMapping
    public ResponseEntity<NoticeResponse> getNotice(@RequestHeader("Authorization") UUID userId) {
        return ResponseEntity.ok(noticeService.getNotice(userId));
    }

}
