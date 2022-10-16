package com.eventsourcing.retailbanking.cqrs.usercommandapi.security;

public interface PasswordEncoder {
    String hashPassword(String password);
}
