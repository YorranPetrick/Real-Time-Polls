package com.yo.RealTimePolls.controller.user;

import com.yo.RealTimePolls.models.User.UserCreateRequest;
import com.yo.RealTimePolls.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    UserController (UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    private ResponseEntity<String> createUser(@RequestBody @Valid UserCreateRequest request) {
        return userService.createUser(request);
    }
}
