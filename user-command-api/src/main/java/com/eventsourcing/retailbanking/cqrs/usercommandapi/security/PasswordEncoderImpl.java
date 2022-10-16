package com.eventsourcing.retailbanking.cqrs.usercommandapi.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String hashPassword(String password) {
        var encoder = new BCryptPasswordEncoder(12);
        return encoder.encode(password);
    }
}
