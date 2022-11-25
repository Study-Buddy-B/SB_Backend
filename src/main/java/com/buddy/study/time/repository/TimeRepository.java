package com.buddy.study.time.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.TimeReportResponse;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TimeRepository extends JpaRepository<Time, Long> {
    @Query("select t from Time t where t.account = :account and t.date like :date%")
    List<Time> findAllByDateAndAccount(String date, Account account); // date YYYY-MM

    @Query("select t.date, AVG(t.time), SUM(t.time), MAX(t.time), MIN(t.time) from Time t where t.account = :account and t.date like :date%")
    TimeReportResponse findReportByDateAndAccount(String date, Account account);
}
