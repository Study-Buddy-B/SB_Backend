package com.buddy.study.time.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Time {
    @Id
    @GeneratedValue
    @Column(name="timeId")
    private Long id;
}
