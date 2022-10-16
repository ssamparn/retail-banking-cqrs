package com.eventsourcing.retailbanking.cqrs.userqueryapi.web.model;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import com.eventsourcing.retailbanking.cqrs.usercore.models.response.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserLookUpResponse extends BaseResponse {

    private List<User> users;

    public UserLookUpResponse(String message) {
        super(message);
    }

    public UserLookUpResponse(List<User> users) {
        super(null);
        this.users = users;
    }

    public UserLookUpResponse(User user) {
        super(null);
        this.users = new ArrayList<>();
        this.users.add(user);
    }
}
