package com.yo.RealTimePolls.models.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserCreateRequest(
        @NotNull(message = "Name cannot be null")
        String name,
        @NotNull(message = "Email cannot be null")
                @Email
        String email
) {
}
