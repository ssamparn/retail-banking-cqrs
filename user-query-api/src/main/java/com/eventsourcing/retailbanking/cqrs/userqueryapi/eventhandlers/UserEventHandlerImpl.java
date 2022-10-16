package com.eventsourcing.retailbanking.cqrs.userqueryapi.eventhandlers;

import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRegisteredEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRemovedEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserUpdatedEvent;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ProcessingGroup("user-group")
public class UserEventHandlerImpl implements UserEventHandler {

    private final UserRepository userRepository;

    @Override
    @EventHandler
    public void on(UserRegisteredEvent event) {
        userRepository.save(event.getUser());
    }

    @Override
    @EventHandler
    public void on(UserUpdatedEvent event) {
        userRepository.save(event.getUser());
    }

    @Override
    @EventHandler
    public void on(UserRemovedEvent event) {
        userRepository.deleteById(event.getId());
    }
}
