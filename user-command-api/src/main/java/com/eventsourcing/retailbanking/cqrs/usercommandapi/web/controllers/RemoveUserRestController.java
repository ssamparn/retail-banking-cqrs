package com.eventsourcing.retailbanking.cqrs.usercommandapi.web.controllers;

import com.eventsourcing.retailbanking.cqrs.usercommandapi.commands.RemoveUserCommand;
import com.eventsourcing.retailbanking.cqrs.usercore.models.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/remove-user")
public class RemoveUserRestController {

    private final CommandGateway commandGateway;

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BaseResponse> removeUser(@PathVariable(value = "id") String id) {
        try {
            commandGateway.sendAndWait(new RemoveUserCommand(id));
            return new ResponseEntity<>(new BaseResponse("User successfully deleted!"), HttpStatus.OK);
        } catch (Exception e) {
            String safeErrorMessage = "Error while processing remove user request for id: " + id;
            log.error(safeErrorMessage);
            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
