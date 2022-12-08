package com.buddy.study.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
  private Float curTime;
  private Integer tarTime;
  private Float temperature;
  private Boolean isAppropriate;
}
