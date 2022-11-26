package com.buddy.study.group.domain;

import com.buddy.study.account.domain.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Mapping {
    @Id
    @GeneratedValue
    @Column(name="mapId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;
}

