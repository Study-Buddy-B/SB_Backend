package com.buddy.study.group.domain;

import com.buddy.study.group.dto.GroupType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "study_group")
@Setter
@Getter
public class Group {
    @Id
    @GeneratedValue
    @Column(name="groupId")
    private Long id;
    private String name;
    private Integer time;
    @Enumerated(value=EnumType.STRING)
    private GroupType groupType;
    private Integer maxPerson;
    private Integer curPerson=0;
    private Boolean isDelete=false;
}
