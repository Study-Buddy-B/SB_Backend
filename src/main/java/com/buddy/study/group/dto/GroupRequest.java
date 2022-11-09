package com.buddy.study.group.dto;

import lombok.Getter;

@Getter
public class GroupRequest {
    private String name;
    private Integer time;
    private Integer type;
    private Integer maxPerson;
}
