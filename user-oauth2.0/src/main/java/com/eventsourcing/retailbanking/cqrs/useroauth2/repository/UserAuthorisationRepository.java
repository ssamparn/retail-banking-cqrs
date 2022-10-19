package com.eventsourcing.retailbanking.cqrs.useroauth2.repository;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserAuthorisationRepository extends MongoRepository<User, String> {
    @Query("{'account.username': ?0}")
    Optional<User> findByUsername(String username);
}
