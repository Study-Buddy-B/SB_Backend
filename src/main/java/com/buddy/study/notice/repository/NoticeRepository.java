package com.buddy.study.notice.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.notice.domain.Notice;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Notice findTopByAccount(Account account);
}
