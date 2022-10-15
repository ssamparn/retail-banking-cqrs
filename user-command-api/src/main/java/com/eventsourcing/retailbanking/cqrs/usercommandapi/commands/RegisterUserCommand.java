package com.eventsourcing.retailbanking.cqrs.usercommandapi.commands;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;

    private User user;
}
