package com.eventsourcing.retailbanking.cqrs.userqueryapi.eventhandlers;

import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindAllUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindUserByIdQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.SearchUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.web.model.UserLookUpResponse;

public interface UserQueryHandler {
    UserLookUpResponse searchUsers(SearchUsersQuery query);
    UserLookUpResponse getUserById(FindUserByIdQuery query);
    UserLookUpResponse getAllUsers(FindAllUsersQuery query);
}
