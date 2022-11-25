package com.buddy.study.notice.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.notice.domain.Notice;
import com.buddy.study.notice.dto.CreateRequest;
import com.buddy.study.notice.dto.NoticeResponse;
import com.buddy.study.notice.repository.NoticeRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    private final AccountService accountService;

    public NoticeResponse createNotice(UUID userId, CreateRequest request) {
        Account account = accountService.findUser(userId);

        String content = "현재 온도가 " + request.getCurrent() + "도입니다.\n" + request.getRequired() + "도가 되도록 조절해주세요!";
        Notice notice = new Notice(content, account);
        return new NoticeResponse(noticeRepository.save(notice));
    }

    public NoticeResponse getNotice(UUID userId) {
        Account account = accountService.findUser(userId);

        return new NoticeResponse(noticeRepository.findTopByAccount(account));
    }
}
