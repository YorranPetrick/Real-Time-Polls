package com.yo.RealTimePolls.service.user;

import com.yo.RealTimePolls.models.User.User;
import com.yo.RealTimePolls.models.User.UserCreateRequest;
import com.yo.RealTimePolls.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> createUser(UserCreateRequest request) {
        try {
            if (userRepository.existsByEmail(request.email())) {
                return ResponseEntity.status(409).body("Email already in use");
            } else {
                User user = new User(request.name(), request.email());
                userRepository.save(user);
                return ResponseEntity.ok("User created successfully");
            }
        }catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
}
