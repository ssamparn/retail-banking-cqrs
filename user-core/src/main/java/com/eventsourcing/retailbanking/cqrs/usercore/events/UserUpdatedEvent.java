package com.eventsourcing.retailbanking.cqrs.usercore.events;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "create")
public class UserUpdatedEvent {
    private String id;
    private User user;
}
