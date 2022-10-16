package com.eventsourcing.retailbanking.cqrs.usercommandapi.commands;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UpdateUserCommand {

    @TargetAggregateIdentifier
    private String id;

    @Valid
    @NotNull(message = "user details can not be empty")
    private User user;
}
