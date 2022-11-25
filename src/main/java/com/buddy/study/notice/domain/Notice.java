package com.buddy.study.notice.domain;

import com.buddy.study.account.domain.Account;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue
    @Column(name="noticeId")
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    @Column
    private Account account;

    public Notice(String content, Account account) {
        this.content = content;
        this.account = account;
    }
}
