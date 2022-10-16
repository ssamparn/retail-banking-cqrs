package com.eventsourcing.retailbanking.cqrs.usercore.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {
    private String message;
}
