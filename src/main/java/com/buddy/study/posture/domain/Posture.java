package com.buddy.study.posture.domain;

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
public class Posture {
    @Id
    @GeneratedValue
    @Column(name="postureId")
    private Long id;

    @Column
    private Boolean isAppropriate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Account account;

    public Posture(Boolean isAppropriate, Account account) {
        this.isAppropriate = isAppropriate;
        this.account = account;
    }
}
