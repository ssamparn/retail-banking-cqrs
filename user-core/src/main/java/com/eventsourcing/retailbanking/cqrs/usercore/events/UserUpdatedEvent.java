package com.eventsourcing.retailbanking.cqrs.usercore.events;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUpdatedEvent {
    private String id;
    private User user;
}
