package com.buddy.study.notice.service;

import com.buddy.study.notice.dto.CreateRequest;
import com.buddy.study.notice.dto.NoticeResponse;
import com.buddy.study.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;


    public NoticeResponse createNotice(CreateRequest request) {
        return null;
    }

    public NoticeResponse getNotice() {
        return null;
    }
}
