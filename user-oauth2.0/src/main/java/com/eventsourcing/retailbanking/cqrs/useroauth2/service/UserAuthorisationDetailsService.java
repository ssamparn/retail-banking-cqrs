package com.eventsourcing.retailbanking.cqrs.useroauth2.service;

import com.eventsourcing.retailbanking.cqrs.usercore.models.Account;
import com.eventsourcing.retailbanking.cqrs.usercore.models.User;
import com.eventsourcing.retailbanking.cqrs.useroauth2.repository.UserAuthorisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserAuthorisationDetailsService implements UserDetailsService {

    private final UserAuthorisationRepository userAuthorisationRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userAuthorisationRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Incorrect username / password supplied!");
        }

        Account account = userOptional.get().getAccount();

        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password(account.getPassword())
                .authorities(account.getRoles())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
