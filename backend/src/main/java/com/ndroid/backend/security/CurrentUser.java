package com.ndroid.backend.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ndroid.backend.exception.UnauthorizedException;

@Component
public class CurrentUser {
    public AppUserPrinciple require() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null || !(auth.getPrincipal() instanceof AppUserPrinciple principal)) {
            throw new UnauthorizedException("Not Authenticated");
        }
        return principal;
    }
}
