package com.buddy.study.group.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.group.domain.Mapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingRepository extends JpaRepository<Mapping,Long> {
}
