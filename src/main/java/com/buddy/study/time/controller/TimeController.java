package com.buddy.study.time.controller;

import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.CreateRequest;
import com.buddy.study.time.dto.TimeReportResponse;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.service.TimeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/time")
public class TimeController {
    private final TimeService timeService;

    @PostMapping("")
    public ResponseEntity<TimeResponse> createTime(@RequestBody CreateRequest request) {
        return ResponseEntity.ok(timeService.createTime(request));
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<List<TimeResponse>> getTimesByMonth(@PathVariable String month) {
        return ResponseEntity.ok(timeService.getTimesByMonth(month));
    }

    @GetMapping("/month/{month}/report")
    public ResponseEntity<TimeReportResponse> getReportByMonth(@PathVariable String month) {
        return ResponseEntity.ok(timeService.getTimeReportByMonth(month));
    }

}
