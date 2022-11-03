package com.buddy.study.account.repository;

import com.buddy.study.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByEmail(String email);
    Account findByName(String name);
}
