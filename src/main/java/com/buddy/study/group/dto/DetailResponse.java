package com.buddy.study.group.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailResponse {
  private String name;
  private Float curTime;
  private Boolean completion;
}
