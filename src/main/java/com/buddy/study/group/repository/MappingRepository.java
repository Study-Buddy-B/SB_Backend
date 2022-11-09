package com.buddy.study.group.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.group.domain.Mapping;
import com.buddy.study.group.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MappingRepository extends JpaRepository<Mapping,Long> {
    @Query("select m.group from Mapping m where m.account=:account")
    List<StudyGroup> findAllByAccount(@Param("account") Account account);
}
