package com.eventsourcing.retailbanking.cqrs.bankaccountqueryapi.repository;

import com.eventsourcing.retailbanking.cqrs.bankaccountqueryapi.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccountEntity, String> {
}
