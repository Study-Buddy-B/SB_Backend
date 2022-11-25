package com.buddy.study.notice.controller;

import com.buddy.study.notice.dto.CreateRequest;
import com.buddy.study.notice.dto.NoticeResponse;
import com.buddy.study.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<NoticeResponse> createNotice(CreateRequest request) {
        return ResponseEntity.ok(noticeService.createNotice(request));
    }

    @GetMapping
    public ResponseEntity<NoticeResponse> getNotice() {
        return ResponseEntity.ok(noticeService.getNotice())
    }

}
