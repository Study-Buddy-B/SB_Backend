package com.buddy.study.posture.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.posture.domain.Posture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostureRepository extends JpaRepository<Posture, Long> {

    Optional<Posture> findTopByAccountOrderByIdDesc(Account account);
}
