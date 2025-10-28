package com.yo.RealTimePolls.repository;


import com.yo.RealTimePolls.models.polls.Polls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PollsRepository extends JpaRepository<Polls, UUID> {
}
