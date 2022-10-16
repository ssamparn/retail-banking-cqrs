package com.eventsourcing.retailbanking.cqrs.usercore.events;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class UserRegisteredEvent {
    private String id;
    private User user;
}
