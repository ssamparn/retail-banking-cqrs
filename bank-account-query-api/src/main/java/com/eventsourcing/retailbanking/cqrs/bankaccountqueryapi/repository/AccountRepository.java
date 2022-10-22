package com.eventsourcing.retailbanking.cqrs.bankaccountqueryapi.repository;

import com.eventsourcing.retailbanking.cqrs.bankaccountcore.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount, String> {
}
