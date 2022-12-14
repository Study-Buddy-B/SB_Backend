package com.buddy.study.temperature.controller;

import com.buddy.study.temperature.dto.CreateRequest;
import com.buddy.study.temperature.dto.TemperatureResponse;
import com.buddy.study.temperature.service.TemperatureService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/temperature")
public class TemperatureController {
    private final TemperatureService noticeService;
    @Operation(summary = "온도 업데이트")
    @PostMapping
    public ResponseEntity<TemperatureResponse> createTemperature(@RequestHeader("Authorization") UUID userId, @RequestBody CreateRequest request) {
        return ResponseEntity.ok(noticeService.createTemperature(userId, request));
    }
    @Operation(summary = "온도 조회")
    @GetMapping
    public ResponseEntity<TemperatureResponse> getTemperature(@RequestHeader("Authorization") UUID userId) {
        return ResponseEntity.ok(noticeService.getTemperature(userId));
    }

}
