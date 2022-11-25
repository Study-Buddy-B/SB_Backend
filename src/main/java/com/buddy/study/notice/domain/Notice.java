package com.buddy.study.notice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notice {
    @Id
    @GeneratedValue
    @Column(name="noticeId")
    private Long id;
}
