package com.ndroid.backend.dto;

import java.util.UUID;

public record UserResponse(
        UUID id,
        Long githubid,
        String githubUsername,
        String displayName,
        String avatarUrl) {
}
