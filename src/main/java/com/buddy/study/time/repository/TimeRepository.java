package com.buddy.study.time.repository;

import com.buddy.study.time.domain.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
