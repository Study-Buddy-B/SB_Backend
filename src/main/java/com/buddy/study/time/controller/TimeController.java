package com.buddy.study.time.controller;

import com.buddy.study.time.dto.CreateRequest;
import com.buddy.study.time.dto.TimeReportResponse;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.service.TimeService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/time")
public class TimeController {
    private final TimeService timeService;
    @Operation(summary = "시간 업데이트")
    @PostMapping("")
    public ResponseEntity<TimeResponse> createTime(@RequestHeader("Authorization") UUID userId, @RequestBody CreateRequest request) {
        return ResponseEntity.ok(timeService.createTime(userId, request));
    }

    @Operation(summary = "일 공부 시간 출력")
    @GetMapping("/date/{date}")
    public ResponseEntity<TimeResponse> getTimeByDate(@RequestHeader("Authorization") UUID userId, @PathVariable String date) {
        String formattedDate =  timeService.validateDate(date);
        System.out.println(formattedDate);
        return ResponseEntity.ok(timeService.getTimeByDate(userId, formattedDate));
    }

    @Operation(summary = "월 시간 통계(평균,최소,최대)")
    @GetMapping("/month/{month}/report")
    public ResponseEntity<TimeReportResponse> getReportByMonth(@RequestHeader("Authorization") UUID userId, @PathVariable String month) {
        String formattedMonth =  timeService.validateMonth(month);
        System.out.println(formattedMonth);
        return ResponseEntity.ok(timeService.getTimeReportByMonth(userId, formattedMonth));
    }

    @Operation(summary = "오늘 공부 시간 출력")
    @GetMapping("/today")
    public ResponseEntity<TimeResponse> getTodayTime(@RequestHeader("Authorization") UUID userId) {
        return ResponseEntity.ok(timeService.getTodayTime(userId));
    }

}
