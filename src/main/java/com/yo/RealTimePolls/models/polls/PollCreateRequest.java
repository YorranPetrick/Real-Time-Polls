package com.yo.RealTimePolls.models.polls;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public record PollCreateRequest(
        @NotNull(message = "Question cannot be null")
        String question,
        @NotNull(message = "End date cannot be null")
        String endDate,
        @NotNull(message = "Email creator cannot be null")
                @Email
        String emailCreator
) {
}
