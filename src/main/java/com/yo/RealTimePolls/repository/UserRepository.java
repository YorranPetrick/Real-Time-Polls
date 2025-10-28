package com.yo.RealTimePolls.repository;

import com.yo.RealTimePolls.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
    User findByEmail(String s);
}
