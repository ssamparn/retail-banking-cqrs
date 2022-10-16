package com.eventsourcing.retailbanking.cqrs.userqueryapi.eventhandlers;

import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRegisteredEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRemovedEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserUpdatedEvent;

public interface UserEventHandler {
    void on(UserRegisteredEvent event);
    void on(UserUpdatedEvent event);
    void on(UserRemovedEvent event);
}
