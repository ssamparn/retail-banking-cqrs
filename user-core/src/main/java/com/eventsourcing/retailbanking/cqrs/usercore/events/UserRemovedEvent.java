package com.eventsourcing.retailbanking.cqrs.usercore.events;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRemovedEvent {
    private String id;
}
