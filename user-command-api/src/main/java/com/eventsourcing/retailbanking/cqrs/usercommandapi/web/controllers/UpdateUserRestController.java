package com.eventsourcing.retailbanking.cqrs.usercommandapi.web.controllers;

import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.UpdateUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercore.models.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/update-user")
public class UpdateUserRestController {

    private final CommandGateway commandGateway;

    @PutMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> updateUser(@PathVariable(value = "id") String id,
                                                   @RequestBody @Valid UpdateUserCommand updateUserCommand) {
        try {
            updateUserCommand.setId(id);
            commandGateway.sendAndWait(updateUserCommand);
            return new ResponseEntity<>(new BaseResponse("User successfully updated!"), HttpStatus.OK);
        } catch (Exception e) {
            String safeErrorMessage = "Error while processing update user request for id: " + id;
            log.error(safeErrorMessage);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
