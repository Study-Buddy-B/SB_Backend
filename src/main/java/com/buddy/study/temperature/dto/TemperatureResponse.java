package com.buddy.study.temperature.dto;

import com.buddy.study.temperature.domain.Temperature;
import lombok.Getter;

@Getter
public class TemperatureResponse {
    private Long id;
    private Float current;

    public TemperatureResponse(Temperature temperature) {
        this.id = temperature.getId();
        this.current = temperature.getCurrent();
    }
}
