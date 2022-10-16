package com.eventsourcing.retailbanking.cqrs.userqueryapi.repository;

import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
