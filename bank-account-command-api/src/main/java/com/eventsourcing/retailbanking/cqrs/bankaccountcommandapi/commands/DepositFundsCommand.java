package com.eventsourcing.retailbanking.cqrs.bankaccountcommandapi.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class DepositFundsCommand {
    @TargetAggregateIdentifier
    private String id;
    private double amountToBeDeposited;
}
