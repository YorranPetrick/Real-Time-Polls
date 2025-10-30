package com.yo.RealTimePolls.models.responsePolls;

import jakarta.validation.constraints.NotNull;

public record ResponsePollRequest(
        @NotNull(message = "Answer cannot be null")
        String answer,
        @NotNull(message = "User cannot be null")
        String userAnswer, //User who is giving the answer
        @NotNull(message = "Poll cannot be null")
        String poll
) {
}
