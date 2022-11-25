package com.buddy.study.notice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateRequest {
    private Integer type;
    private Float current;
    private Float required;
}
