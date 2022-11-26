package com.buddy.study.time.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.time.domain.Time;
import com.buddy.study.time.dto.TimeReportResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimeRepository extends JpaRepository<Time, Long> {
    @Query("select t from Time t where t.account = :account and t.date like :date% order by t.date")
    List<Time> findAllByDateAndAccount(@Param("date") String date, @Param("account") Account account); // date YYYY-MM

    @Query("select new com.buddy.study.time.dto.TimeReportResponse(AVG(t.time), SUM(t.time), MAX(t.time), MIN(t.time)) from Time t where t.account = :account and t.date like :date%")
    TimeReportResponse findReportByDateAndAccount(@Param("date") String date, @Param("account") Account account);

    @Query("select t from Time t where t.account = :account and t.date like :date%")
    Optional<Time> findOneByDateAndAccount(@Param("date") String date, @Param("account") Account account);
}
