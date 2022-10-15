package com.eventsourcing.retailbanking.cqrs.usercore.events;

import lombok.Data;

@Data
public class UserRemovedEvent {
    private String id;
}
