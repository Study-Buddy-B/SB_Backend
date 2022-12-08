package com.buddy.study.temperature.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.service.AccountService;
import com.buddy.study.temperature.domain.Temperature;
import com.buddy.study.temperature.dto.CreateRequest;
import com.buddy.study.temperature.dto.TemperatureResponse;
import com.buddy.study.temperature.repository.TemperatureRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemperatureService {
    private final TemperatureRepository temperatureRepository;

    private final AccountService accountService;

    public TemperatureResponse createTemperature(UUID userId, CreateRequest request) {
        Account account = accountService.findUser(userId);

        Temperature temperature = new Temperature(request.getCurrent(), account);
        return new TemperatureResponse(temperatureRepository.save(temperature));
    }

    public TemperatureResponse getTemperature(UUID userId) {
        Account account = accountService.findUser(userId);

        return new TemperatureResponse(temperatureRepository.findTopByAccountOrderByIdDesc(account));
    }
}
