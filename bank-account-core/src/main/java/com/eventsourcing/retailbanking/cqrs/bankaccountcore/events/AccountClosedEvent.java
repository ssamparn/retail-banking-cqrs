package com.eventsourcing.retailbanking.cqrs.bankaccountcore.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class AccountClosedEvent {
    private String id;
}
