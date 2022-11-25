package com.buddy.study.time.domain;

import com.buddy.study.account.domain.Account;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Time {
    @Id
    @GeneratedValue
    @Column(name="timeId")
    private Long id;

    @Column
    private String date;

    @Column
    private Float time;

    @ManyToOne
    @JoinColumn(name="userId")
    private Account account;

    @Builder
    public Time(String date, Float time, Account account) {
        this.date = date;
        this.time = time;
        this.account = account;
    }
}
