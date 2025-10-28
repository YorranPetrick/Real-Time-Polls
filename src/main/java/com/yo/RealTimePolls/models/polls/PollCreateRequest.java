package com.yo.RealTimePolls.models.polls;

import com.yo.RealTimePolls.models.statusPolls.Status;

import java.time.Instant;

public record PollCreateRequest(
        String question,
        Status status,
        String endDate,
        String emailCreator
) {
}
