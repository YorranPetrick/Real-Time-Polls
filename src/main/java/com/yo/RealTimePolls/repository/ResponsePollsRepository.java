package com.yo.RealTimePolls.repository;

import com.yo.RealTimePolls.models.responsePolls.ResponsePolls;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResponsePollsRepository extends JpaRepository<ResponsePolls, UUID> {
}
