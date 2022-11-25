package com.buddy.study.time.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.common.dto.ErrorCode;
import com.buddy.study.common.exception.ConflictException;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.CreateRequest;
import com.buddy.study.time.dto.TimeReportResponse;
import com.buddy.study.time.dto.TimeResponse;
import com.buddy.study.time.repository.TimeRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    public String validateDate(String date) { // yyyy-MM 형식인지 검증
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            simpleDateFormat.setLenient(false);
            Date result = simpleDateFormat.parse(date);
            return simpleDateFormat.format(result);
        } catch(ParseException e) {
            throw new ConflictException(ErrorCode.INVALIDATE_DATE);
        }
    }
    public TimeResponse createTime(UUID userId, CreateRequest request) {
        Account account = accountService.findUser(userId);
        String today = LocalDate.now().toString();

        Optional<Time> exist = timeRepository.findOneByDateAndAccount(today, account);
        Time time = exist.orElseGet(() -> Time.builder()
            .date(today)
            .time(0F)
            .account(account)
            .build());
        time.setTime(time.getTime()+request.getTime());
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

        TimeReportResponse response = timeRepository.findReportByDateAndAccount(month, account);
        response.setMonth(month);
        return response;
    }

    public TimeResponse getTodayTime(UUID userId) {
        Account account = accountService.findUser(userId);

        String today = LocalDate.now().toString();
        Time time = timeRepository.findOneByDateAndAccount(today, account)
            .orElse(new Time(today,0F, account));
        return new TimeResponse(time);
    }
}
