package com.eventsourcing.retailbanking.cqrs.bankaccountcore.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class FundsDepositedEvent {
    private String id;
    private double amountToBeDeposited;
    private double balance;
}
