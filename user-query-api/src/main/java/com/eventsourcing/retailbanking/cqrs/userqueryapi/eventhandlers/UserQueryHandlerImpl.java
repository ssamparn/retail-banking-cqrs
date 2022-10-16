package com.eventsourcing.retailbanking.cqrs.userqueryapi.eventhandlers;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindAllUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.FindUserByIdQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.queries.SearchUsersQuery;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.repository.UserRepository;
import com.eventsourcing.retailbanking.cqrs.userqueryapi.web.model.UserLookUpResponse;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryHandlerImpl implements UserQueryHandler {

    private final UserRepository userRepository;

    @Override
    @QueryHandler
    public UserLookUpResponse searchUsers(SearchUsersQuery query) {
        List<User> userList = userRepository.findByFilterRegex(query.getFilter());
        return new UserLookUpResponse(userList);
    }

    @Override
    @QueryHandler
    public UserLookUpResponse getUserById(FindUserByIdQuery query) {
        Optional<User> userOptional = userRepository.findById(query.getId());
        return userOptional.map(UserLookUpResponse::new).orElse(null);
    }

    @Override
    @QueryHandler
    public UserLookUpResponse getAllUsers(FindAllUsersQuery query) {
        List<User> userList = userRepository.findAll();
        return new UserLookUpResponse(userList);
    }
}
