package com.ndroid.backend.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndroid.backend.dto.UserResponse;
import com.ndroid.backend.entity.User;
import com.ndroid.backend.security.AppUserPrinciple;
import com.ndroid.backend.security.CurrentUser;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CurrentUser currentUser;

    @GetMapping("/login-url")
    public Map<String, String> loginUrl() {
        return Map.of("url", "/oauth/authorization/github");
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me() {
        AppUserPrinciple principal = currentUser.require();
        User user = principal.getUser();

        return ResponseEntity.ok(new UserResponse(
                user.getId(),
                user.getGithubId(),
                user.getGithubUsername(),
                user.getDisplayName(),
                user.getAvatarUrl()
                ));
    }
}
