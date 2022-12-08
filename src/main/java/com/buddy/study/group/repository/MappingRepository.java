package com.buddy.study.group.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.group.domain.Mapping;
import com.buddy.study.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MappingRepository extends JpaRepository<Mapping,Long> {
    @Query("select m.group from Mapping m where m.account=:account order by m.group.id desc")
    List<Group> findAllByAccount(@Param("account") Account account);
    List<Mapping> findAllByGroup(Group group);
}
