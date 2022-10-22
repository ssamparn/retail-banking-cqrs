package com.eventsourcing.retailbanking.cqrs.bankaccountcore.events;

import com.eventsourcing.retailbanking.cqrs.bankaccountcore.models.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class AccountOpenedEvent {
    private String id;
    private String accountHolderId;
    private AccountType accountType;
    private LocalDate creationDate;
    private double openingBalance;
}
