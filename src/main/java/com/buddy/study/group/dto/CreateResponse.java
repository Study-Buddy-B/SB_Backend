package com.buddy.study.group.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

public class CreateResponse {
    private Long groupId;
    public CreateResponse(Long groupId){this.groupId=groupId;}
}
