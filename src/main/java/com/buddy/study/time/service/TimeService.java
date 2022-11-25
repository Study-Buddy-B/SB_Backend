package com.buddy.study.time.service;

import com.buddy.study.time.dto.CreateRequest;
import com.buddy.study.time.dto.TimeReportResponse;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.repository.TimeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeService {
    private final TimeRepository timeRepository;

    public TimeResponse createTime(CreateRequest request) {
        return null;
    }

    public List<TimeResponse> getTimesByMonth(String month) {
        return null;
    }

    public TimeReportResponse getTimeReportByMonth(String month) {
        return null;
    }

}
