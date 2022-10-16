package com.eventsourcing.retailbanking.cqrs.userqueryapi.web.controller;

import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindAllUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindUserByIdQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.SearchUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.web.model.UserLookUpResponse;
import lombok.RequiredArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/user-lookup")
public class UserLookupRestController {

    private final QueryGateway queryGateway;

    @GetMapping(value = "/")
    public ResponseEntity<UserLookUpResponse> getAllUsers() {
        try {
            FindAllUsersQuery query = new FindAllUsersQuery();
            UserLookUpResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

            if (response == null || response.getUsers() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete get all users request!";
            return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage) , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/by-id/{id}")
    public ResponseEntity<UserLookUpResponse> getUserById(@PathVariable(value = "id") String id) {
        try {
            FindUserByIdQuery query = new FindUserByIdQuery(id);
            UserLookUpResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

            if (response == null || response.getUsers() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete user by id request!";
            return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage) , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/by-filter/{filter}")
    public ResponseEntity<UserLookUpResponse> filterUser(@PathVariable(value = "filter") String filter) {
        try {
            SearchUsersQuery query = new SearchUsersQuery(filter);
            UserLookUpResponse response = queryGateway.query(query, ResponseTypes.instanceOf(UserLookUpResponse.class)).join();

            if (response == null || response.getUsers() == null) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Failed to complete user search request!";
            return new ResponseEntity<>(new UserLookUpResponse(safeErrorMessage) , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
