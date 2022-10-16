package com.eventsourcing.retailbanking.cqrs.usercommandapi.web.controllers;

import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.RegisterUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercommandapi.web.model.RegisteredUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/register-user")
public class RegisterUserRestController {

    private final CommandGateway commandGateway;

    @PostMapping
    public ResponseEntity<RegisteredUserResponse> registerUser(@Valid @RequestBody RegisterUserCommand registerUserCommand) {
        String id = UUID.randomUUID().toString();
        try {
            registerUserCommand.setId(id);
            commandGateway.sendAndWait(registerUserCommand);
            return new ResponseEntity<>(new RegisteredUserResponse(id, "User successfully registered!"), HttpStatus.CREATED);
        } catch (Exception e) {
            String safeErrorMessage = "Error while processing register user request for id: " + id;
            log.error(safeErrorMessage);
            return new ResponseEntity<>(new RegisteredUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
