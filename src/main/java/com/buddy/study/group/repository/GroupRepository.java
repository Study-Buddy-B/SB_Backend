package com.buddy.study.group.repository;

import com.buddy.study.group.domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<StudyGroup,Long> {
    List<StudyGroup> findAllByOrderByIdDesc();
}
