package com.buddy.study.group.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class StudyGroup {
    @Id
    @GeneratedValue
    @Column(name="groupId")
    private Long id;
    private String name;
    private Integer time;
    private Integer maxPerson;
    private Boolean isDelete=false;
}
