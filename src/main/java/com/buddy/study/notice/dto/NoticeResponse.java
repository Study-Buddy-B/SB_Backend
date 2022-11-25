package com.buddy.study.notice.dto;

import com.buddy.study.notice.domain.Notice;
import lombok.Getter;

@Getter
public class NoticeResponse {
    private Long id;
    private String content;

    public NoticeResponse(Notice notice) {
        this.id = notice.getId();
        this.content = notice.getContent();
    }
}
