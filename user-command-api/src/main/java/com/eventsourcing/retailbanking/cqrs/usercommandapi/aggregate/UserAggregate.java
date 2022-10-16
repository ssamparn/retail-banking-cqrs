package com.eventsourcing.retailbanking.cqrs.usercommandapi.aggregate;

import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.RegisterUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.RemoveUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.UpdateUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercommandapi.security.PasswordEncoder;
import com.eventsourcing.retailbanking.cqrs.usercommandapi.security.PasswordEncoderImpl;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRegisteredEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserRemovedEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.events.UserUpdatedEvent;
import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Objects;
import java.util.UUID;

@Aggregate
public class UserAggregate {

    private PasswordEncoder passwordEncoder;

    @AggregateIdentifier
    private String id;

    private User user;

    public UserAggregate() {
        this.passwordEncoder = new PasswordEncoderImpl();
    }

    @CommandHandler
    public UserAggregate(RegisterUserCommand command) {
        User newUser = command.getUser();
        newUser.setId(command.getId());
        String password = newUser.getAccount().getPassword();
        this.passwordEncoder = new PasswordEncoderImpl();
        String hashedPassword = Objects.requireNonNull(passwordEncoder).hashPassword(password);
        newUser.getAccount().setPassword(hashedPassword);

        UserRegisteredEvent userRegisteredEvent = UserRegisteredEvent.create(
                command.getId(),
                newUser
        );

        AggregateLifecycle.apply(userRegisteredEvent);
    }

    @CommandHandler
    public void handle(UpdateUserCommand command) {
        User updatedUser = command.getUser();
        updatedUser.setId(command.getId());
        String password = updatedUser.getAccount().getPassword();
        this.passwordEncoder = new PasswordEncoderImpl();
        String hashedPassword = Objects.requireNonNull(passwordEncoder).hashPassword(password);
        updatedUser.getAccount().setPassword(hashedPassword);

        UserUpdatedEvent userUpdatedEvent = UserUpdatedEvent.create(
                UUID.randomUUID().toString(),
                updatedUser
        );

        AggregateLifecycle.apply(userUpdatedEvent);
    }

    @CommandHandler
    public void handle(RemoveUserCommand command) {
        UserRemovedEvent userRemovedEvent = new UserRemovedEvent();
        userRemovedEvent.setId(command.getId());

        AggregateLifecycle.apply(userRemovedEvent);
    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event) {
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event) {
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}
