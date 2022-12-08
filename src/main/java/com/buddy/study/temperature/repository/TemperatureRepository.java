package com.buddy.study.temperature.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.temperature.domain.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
    Temperature findTopByAccountOrderByIdDesc(Account account);
}
