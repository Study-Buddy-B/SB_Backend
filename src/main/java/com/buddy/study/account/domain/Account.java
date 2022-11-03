package com.buddy.study.account.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue
    @Column(name="userId")
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean isDelete=false;
}
