package com.buddy.study.time.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeReportResponse {
    private Float average;
    private Float cumulative;
    private Float maximum;
    private Float minimum;
    private String month;

    public TimeReportResponse(Double average, Double cumulative, Float maximum, Float minimum) {
        this.average = average.floatValue();
        this.cumulative = cumulative.floatValue();
        this.maximum = maximum;
        this.minimum = minimum;
    }
}
