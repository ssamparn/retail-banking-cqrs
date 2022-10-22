package com.eventsourcing.retailbanking.cqrs.bankaccountcommandapi.commands;

import com.eventsourcing.retailbanking.cqrs.bankaccountcore.models.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class OpenAccountCommand {
    @TargetAggregateIdentifier
    private String id;
    private String accountHolderId;
    private AccountType accountType;
    private double openingBalance;
}
