package com.buddy.study.group.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetailsResponse {
  private Integer tarTime;
  private List<DetailResponse> detailResponses;
}
