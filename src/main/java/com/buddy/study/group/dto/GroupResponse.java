package com.buddy.study.group.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupResponse {
    private Long gid;
    private String name;
    private String type;
    private Integer curPerson;
    private Integer maxPerson;
}
