package com.eventsourcing.retailbanking.cqrs.usercommandapi.web.model;

import com.eventsourcing.retailbanking.cqrs.usercore.models.response.BaseResponse;

public class RegisteredUserResponse extends BaseResponse {
    private String id;

    public RegisteredUserResponse(String id, String message) {
        super(message);
        this.id = id;
    }
}
