package com.buddy.study.time.dto;

import lombok.Getter;

@Getter
public class TimeReportResponse {
    private String month;
    private Float average;
    private Float cumulative;
    private Float maximum;
    private Float minimum;
}
