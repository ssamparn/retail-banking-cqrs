package com.eventsourcing.retailbanking.cqrs.useroauth2.config;

import com.eventsourcing.retailbanking.cqrs.useroauth2.service.UserAuthorisationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomUserAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserAuthorisationDetailsService userAuthorisationDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final UserDetails userDetail = userAuthorisationDetailsService.loadUserByUsername(authentication.getName());
        return new UsernamePasswordAuthenticationToken(
                userDetail.getUsername(),
                userDetail.getPassword(),
                userDetail.getAuthorities()
        );
    }
}
