package com.buddy.study.group.repository;

import com.buddy.study.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Long> {
    List<Group> findAllByOrderByIdDesc();
}
