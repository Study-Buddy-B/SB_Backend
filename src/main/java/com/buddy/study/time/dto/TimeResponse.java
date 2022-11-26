package com.buddy.study.time.dto;

import com.buddy.study.time.domain.Time;
import lombok.Getter;

@Getter
public class TimeResponse {
    private Long id;
    private String date;
    private Float time;

    public TimeResponse(Time time) {
        this.id = time.getId();
        this.date = time.getDate();
        this.time = time.getTime();
    }
}
