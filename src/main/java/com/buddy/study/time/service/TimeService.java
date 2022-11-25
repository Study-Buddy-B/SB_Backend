package com.buddy.study.time.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.CreateRequest;
import com.buddy.study.time.dto.TimeReportResponse;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.repository.TimeRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TimeService {
    private final TimeRepository timeRepository;

    private final AccountService accountService;

    public TimeResponse createTime(UUID userId, CreateRequest request) {
        Account account = accountService.findUser(userId);
        String date = LocalDateTime.now().toString();
        Time time = Time.builder()
            .date(date)
            .time(request.getTime())
            .account(account)
            .build();
        return new TimeResponse(timeRepository.save(time));
    }

    public List<TimeResponse> getTimesByMonth(UUID userId, String month) {
        Account account = accountService.findUser(userId);

        return timeRepository.findAllByDateAndAccount(month,account)
            .stream()
            .map(TimeResponse::new)
            .collect(Collectors.toList());
    }

    public TimeReportResponse getTimeReportByMonth(UUID userId, String month) {
        Account account = accountService.findUser(userId);

        return timeRepository.findReportByDateAndAccount(month, account);
    }

}
