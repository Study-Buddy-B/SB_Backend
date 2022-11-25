package com.buddy.study.temperature.domain;

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
public class Temperature {
    @Id
    @GeneratedValue
    @Column(name="noticeId")
    private Long id;

    @Column
    private Float current;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Account account;

    public Temperature(Float current, Account account) {
        this.current = current;
        this.account = account;
    }
}
